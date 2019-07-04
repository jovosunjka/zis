import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { GenericService } from '../services/generic/generic.service';
import { AuthenticationService } from '../services/authentication/authentication.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-patient-page',
  templateUrl: './patient-page.component.html',
  styleUrls: ['./patient-page.component.css']
})
export class PatientPageComponent implements OnInit {

  xHtmlContetntForSelectedDoctor: string; // dobijen koriscenjem xsl transformacije
  realtiveUrlGetDoctor: string;

  idOfPatientNum: string;

  constructor(private doctorService: GenericService, private authenticationService: AuthenticationService,
              private route: ActivatedRoute, private toastr: ToastrService) {
    this.xHtmlContetntForSelectedDoctor = 'Loading selected doctor...';
    this.realtiveUrlGetDoctor = '/patient/get-doctor';
  }

  ngOnInit() {
    if (this.route.snapshot.params['idOfPatientNum']) {
      this.idOfPatientNum = this.route.snapshot.params['idOfPatientNum'];
    }

    if (this.isPatientUser()) {
      this.getDoctor();
    }
  }

  getDoctor () {
    this.doctorService.get<string>(this.realtiveUrlGetDoctor).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
              // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
              this.xHtmlContetntForSelectedDoctor = this.doctorService.replaceAllBackSlash(receivedXml.substring(1,
                  receivedXml.length - 1));
              // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove
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

  isPatientUser() {
    const roles: any[] = this.authenticationService.getCurrentUser().roles;
    if (roles.includes('PATIENT')) {
      return true;
    }
    return false;
  }

}
