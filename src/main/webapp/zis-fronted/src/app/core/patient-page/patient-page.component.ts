import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { GenericService } from '../services/generic/generic.service';

@Component({
  selector: 'app-patient-page',
  templateUrl: './patient-page.component.html',
  styleUrls: ['./patient-page.component.css']
})
export class PatientPageComponent implements OnInit {

  xHtmlContetntForSelectedDoctor: string; // dobijen koriscenjem xsl transformacije
  realtiveUrlGetDoctor: string;

  constructor(private doctorService: GenericService, private toastr: ToastrService) {
    this.xHtmlContetntForSelectedDoctor = 'Loading selected doctor...';
    this.realtiveUrlGetDoctor = '/patient/get-doctor';
  }

  ngOnInit() {
    this.getDoctor();
  }

  getDoctor () {
    this.doctorService.get<string>(this.realtiveUrlGetDoctor).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
              this.xHtmlContetntForSelectedDoctor = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
              this.toastr.success('Doctor are successfully loaded!');
          }
          else {
            this.xHtmlContetntForSelectedDoctor = 'Doctor was not selected';
            this.toastr.info('Doctor was not selected!');
          }
      },
      (err) => {
        this.xHtmlContetntForSelectedDoctor = 'Problem with loading of doctor!';
        this.toastr.error('Problem with loading of doctor!');
      }
    );
  }

}
