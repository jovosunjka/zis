import { Component, OnInit } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.css']
})
export class PatientsComponent implements OnInit {
  xHtmlContetntForPatients: string; // dobijen koriscenjem xsl transformacije
  relativeUrlPatients: string;

  relativeUrlBasicSearch: string;

  basicSearchText: string;

  constructor(private doctorService: GenericService, private toastr: ToastrService) {
    this.relativeUrlPatients = '/doctor/patients';
    this.relativeUrlBasicSearch = '/doctor/basic-search?text=';
    this.xHtmlContetntForPatients = 'Loading patients...';
    this.basicSearchText = '';
   }

  ngOnInit() {
    this.getPatients();
  }

  getPatients () {
    this.doctorService.get<string>(this.relativeUrlPatients).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
             // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
             this.xHtmlContetntForPatients = this.doctorService.replaceAllBackSlash(receivedXml.substring(1,
                receivedXml.length - 1));
             // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove
              this.toastr.success('Patients are successfully loaded!');
          }
          else {
            this.xHtmlContetntForPatients = 'Problem with loading of patients!';
            this.toastr.error('Problem with loading of patients!');
          }
      },
      (err) => {
        this.xHtmlContetntForPatients = 'Problem with loading of patients!';
        this.toastr.error('Problem with loading of patients!');
      }
    );
  }

  basicSearch() {
    this.doctorService.get<string>(this.relativeUrlBasicSearch + this.basicSearchText).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
               // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
               this.xHtmlContetntForPatients = this.doctorService.replaceAllBackSlash(receivedXml.substring(1,
                 receivedXml.length - 1));
               // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove
              this.toastr.success('Result of basic search is successfully loaded!');
          }
          else {
            this.xHtmlContetntForPatients = 'Problem with loading of result of basic search!';
            this.toastr.info('Problem with loading of result of basic search!');
          }
      },
      (err) => {
        this.xHtmlContetntForPatients = 'Problem with loading of result of basic search!';
        this.toastr.error('Problem with loading of result of basic search!');
      }
    );
  }
}
