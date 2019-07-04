import { Injectable, Injector, Inject } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GenericService {

  constructor(private http: HttpClient, @Inject('BASE_API_URL') private baseUrl: string) {}

  getAll<T>(relativeUrl: string): Observable<T[]> {
    const httpOptions = {
      responseType: 'text' as 'json' // Ovo as 'json' smo dodali samo da ne bismo dobijali kompajlersku gresku.
      // Bez brige, xml text koji bude u http response-u bice posmatran kao xml, nece mu smetati ovo as 'json'
    };
    return this.http.get<T[]>(this.baseUrl + relativeUrl, httpOptions);
  }

  get<T>(relativeUrl: string): Observable<T> {
    // const params: HttpParams = new HttpParams().set('_id',id);
    const httpOptions = {
      responseType: 'text' as 'json' // Ovo as 'json' smo dodali samo da ne bismo dobijali kompajlersku gresku.
      // Bez brige, xml text koji bude u http response-u bice posmatran kao xml, nece mu smetati ovo as 'json'
    };
    return this.http.get<T>(this.baseUrl + relativeUrl, httpOptions);
  }

  getById<T>(relativeUrl: string, id: number): Observable<T> {
    // const params: HttpParams = new HttpParams().set('_id',id);
    return this.http.get<T>(this.baseUrl + relativeUrl + `/${id}`);
  }

  getListById<T>(relativeUrl: string, id: number): Observable<T[]> {
    // const params: HttpParams = new HttpParams().set('_id',id);
    return this.http.get<T[]>(this.baseUrl + relativeUrl + `/${id}`);
  }


  put<T>(relativeUrl: string, t: T): Observable<T> {
    /*const headers: HttpHeaders = new HttpHeaders({'Content-Type': 'application/xml',
                                                  'Accept': 'application/xml'});*/
    const httpOptions = {
      headers: new HttpHeaders({
          'Content-Type':  'application/xml',
          'Accept':  'application/xml',
          // 'Response-Type': 'text'
      }),
      responseType: 'text' as 'json' // Ovo as 'json' smo dodali samo da ne bismo dobijali kompajlersku gresku.
      // Bez brige, xml text koji bude u http response-u bice posmatran kao xml, nece mu smetati ovo as 'json'
    };
    // return this.http.put<T>(this.baseUrl + relativeUrl, t, { headers });
    return this.http.put<T>(this.baseUrl + relativeUrl, t, httpOptions);
  }

  putById<T>(relativeUrl: string, id: string): Observable<T> {
    return this.http.put<T>(this.baseUrl + relativeUrl + id, null);
  }

  save<T>(relativeUrl: string, t: T) {
    const headers: HttpHeaders = new HttpHeaders({'Content-Type': 'application/xml'});
    return this.http.post(this.baseUrl + relativeUrl, t,  { headers });
  }

  post(relativeUrl: string, t: any) {
    /*const headers: HttpHeaders = new HttpHeaders({'Content-Type': 'application/xml',
                                                  'Accept': 'application/xml'});*/
    const httpOptions = {
      headers: new HttpHeaders({
          'Content-Type':  'application/xml',
          'Accept':  'application/xml',
          // 'Response-Type': 'text'
      }),
      responseType: 'text' as 'json' // Ovo as 'json' smo dodali samo da ne bismo dobijali kompajlersku gresku.
      // Bez brige, xml text koji bude u http response-u bice posmatran kao xml, nece mu smetati ovo as 'json'
    };
    // return this.http.post(this.baseUrl + relativeUrl, t, { headers });
    return this.http.post(this.baseUrl + relativeUrl, t, httpOptions);
  }

  delete(relativeUrl: string, id: number) {
    return this.http.delete(this.baseUrl + relativeUrl + `/${id}` + '/delete');
  }

  replaceAllBackSlash(targetStr: string) {
    let index = targetStr.indexOf('\\');
    while (index >= 0) {
      targetStr = targetStr.replace('\\', '');
      index = targetStr.indexOf('\\');
    }
    return targetStr;
  }


}
