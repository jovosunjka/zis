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

  constructor(private patientService: GenericService, private toastr: ToastrService) {
    this.relativeUrlPatients = '/doctor/patients';
    this.xHtmlContetntForPatients = 'Loading patients...';
   }

  ngOnInit() {
    this.getPatients();
  }

  getPatients () {
    this.patientService.get<string>(this.relativeUrlPatients).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
             // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
             this.xHtmlContetntForPatients = this.patientService.replaceAllBackSlash(receivedXml.substring(1,
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

}
