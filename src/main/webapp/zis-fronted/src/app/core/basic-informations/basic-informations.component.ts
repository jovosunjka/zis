import { Component, OnInit, Input } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from '../services/authentication/authentication.service';

@Component({
  selector: 'app-basic-informations',
  templateUrl: './basic-informations.component.html',
  styleUrls: ['./basic-informations.component.css']
})
export class BasicInformationsComponent implements OnInit {
  relativeUrlBasicInformations: string;
  xHtmlContetntForBasicInformations: string; // dobijen koriscenjem xsl transformacije

  @Input()
  xHtmlContetntForSelectedDoctor: string; // dobijen koriscenjem xsl transformacije

  @Input()
  idOfPatientNum: string;


  constructor(private healthCardService: GenericService, private authenticationService: AuthenticationService,
               private toastr: ToastrService) {
    this.relativeUrlBasicInformations = '/patient/health-card-basic-informations';
    this.xHtmlContetntForBasicInformations = 'Loading basic informations...';
  }

  ngOnInit() {
    if (this.idOfPatientNum) {
      this.relativeUrlBasicInformations += '/' + this.idOfPatientNum;
    }
    this.getBasicInformations();
  }

  getBasicInformations () {
    this.healthCardService.get<string>(this.relativeUrlBasicInformations).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
               // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
               this.xHtmlContetntForBasicInformations = this.healthCardService.replaceAllBackSlash(receivedXml.substring(1,
                 receivedXml.length - 1));
               // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove
              this.toastr.success('Basic informations are successfully loaded!');
          }
          else {
            this.xHtmlContetntForBasicInformations = 'Problem with loading of basic informations!';
            this.toastr.info('Problem with loading of basic informations!');
          }
      },
      (err) => {
        this.xHtmlContetntForBasicInformations = 'Problem with loading of basic informations!';
        this.toastr.error('Problem with loading of basic informations!');
      }
    );
  }

  isAllowedDisplaySelectedDoctor() {
    const roles: any[] = this.authenticationService.getCurrentUser().roles;
    if (roles.includes('PATIENT')) {
      return true;
    }
    return false;
  }

}
