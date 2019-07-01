import { Injectable} from '@angular/core';
import { GenericService } from '../generic/generic.service';
import { JwtUtilsService } from '../jwt-utils/jwt-utils.service';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';


@Injectable()
export class AuthenticationService {
  private relativeUrl;
  private currentUserKey = 'currentUser';
  private domParser: DOMParser;

  constructor(private loginService: GenericService, private jwtUtilsService: JwtUtilsService) {
    this.relativeUrl = '/users/login';
    this.domParser = new DOMParser();​​​​​​
  }


  login(username: string, password: string): Observable<boolean> {
    const xml = `<userdto xmlns="http://www.svj.com/zis/dto">
                  <username>${username}</username>
                  <password>${password}</password>
                </userdto>`;
    return this.loginService.put(this.relativeUrl, xml).pipe(
    map(
      (res: string) => {
        // alert(res);
        const document: Document = this.domParser.parseFromString(res, 'application/xml');
        const token = document.getElementsByTagName('tokendto').item(0).textContent;
        // alert(token);
        if (token) {
          localStorage.setItem(this.currentUserKey, JSON.stringify({username, password,
                roles: this.jwtUtilsService.getRoles(token), token: token}));
              return true;
        }
        else {
          return false;
        }
      }
    ),
    catchError((err: any) => {
      if (err.status === 400 ) {
        return Observable.throw('Ilegal login');
      } else {
        return Observable.throw(err.json().error || 'Server error');
      }
    }));
  }


  getToken(): String {
    const currentUser = JSON.parse(localStorage.getItem(this.currentUserKey));
    const token = currentUser && currentUser.token;
    return token ? token : '';
  }

  logout(): void {
    localStorage.removeItem(this.currentUserKey);
  }

  isLoggedIn(): boolean {
    if (this.getToken() !== '') {
      return true;
    }
    return false;
  }

  getCurrentUser() {
    if (localStorage.currentUser) {
      return JSON.parse(localStorage.currentUser);
    } else {
      return undefined;
    }
  }

}
