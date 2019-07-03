import { Component, OnInit, Input } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';

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

  constructor(private healthCardService: GenericService, private toastr: ToastrService) {
    this.relativeUrlBasicInformations = '/patient/health-card-basic-informations';
    this.xHtmlContetntForBasicInformations = 'Loading basic informations...';
  }

  ngOnInit() {
    this.getBasicInformations();
  }

  getBasicInformations () {
    this.healthCardService.get<string>(this.relativeUrlBasicInformations).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
              this.xHtmlContetntForBasicInformations = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
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

}
