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
  relativeUrlBasicSearch: string;
  relativeUrlAdvancedSearch: string;

  xHtmlContetntForBasicInformations: string; // dobijen koriscenjem xsl transformacije
  xHtmlContetntForAdvancedSearch: string;

  @Input()
  xHtmlContetntForSelectedDoctor: string; // dobijen koriscenjem xsl transformacije

  @Input()
  idOfPatientNum: string;

  basicSearchText: string;
  advancedSearchText: string;


  constructor(private healthCardService: GenericService, private authenticationService: AuthenticationService,
               private toastr: ToastrService) {
    this.relativeUrlBasicInformations = '/patient/health-card-basic-informations';
    this.relativeUrlBasicSearch = '/patient/basic-search?text=';
    this.relativeUrlAdvancedSearch = '/patient/advanced-search?text=';
    this.xHtmlContetntForBasicInformations = 'Loading basic informations...';
    this.xHtmlContetntForAdvancedSearch = '';
    this.basicSearchText = '';
    this.advancedSearchText = '';
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

  basicSearch() {
      this.healthCardService.get<string>(this.relativeUrlBasicSearch + this.basicSearchText).subscribe(
        (receivedXml: string) => {
            if (receivedXml) {
                 // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
                 this.xHtmlContetntForBasicInformations = this.healthCardService.replaceAllBackSlash(receivedXml.substring(1,
                   receivedXml.length - 1));
                 // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove
                this.toastr.success('Result of basic search is successfully loaded!');
            }
            else {
              this.xHtmlContetntForBasicInformations = 'Problem with loading of result of basic search!';
              this.toastr.info('Problem with loading of result of basic search!');
            }
        },
        (err) => {
          this.xHtmlContetntForBasicInformations = 'Problem with loading of result of basic search!';
          this.toastr.error('Problem with loading of result of basic search!');
        }
      );
  }

  advancedSearch() {
    this.healthCardService.get<string>(this.relativeUrlBasicSearch + this.advancedSearchText).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
               // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
               this.xHtmlContetntForAdvancedSearch = this.healthCardService.replaceAllBackSlash(receivedXml.substring(1,
                 receivedXml.length - 1));
               // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove
              this.toastr.success('Result of advanced search is successfully loaded!');
          }
          else {
            this.xHtmlContetntForAdvancedSearch = 'Problem with loading of result of advanced search!';
            this.toastr.info('Problem with loading of result of advanced search!');
          }
      },
      (err) => {
        this.xHtmlContetntForAdvancedSearch = 'Problem with loading of result of advanced search!';
        this.toastr.error('Problem with loading of result of advanced search!');
      }
    );
  }
}
