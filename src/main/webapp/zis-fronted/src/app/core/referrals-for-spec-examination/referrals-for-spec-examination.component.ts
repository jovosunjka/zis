import { Component, OnInit, Input } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-referrals-for-spec-examination',
  templateUrl: './referrals-for-spec-examination.component.html',
  styleUrls: ['./referrals-for-spec-examination.component.css']
})
export class ReferralsForSpecExaminationComponent implements OnInit {

  xHtmlContetntForReferralsForSpecExamination: string; // dobijen koriscenjem xsl transformacije
  relativeUrlAllReferralsForSpecExamination: string;

  @Input()
  idOfPatientNum: string;


  constructor(private referralForSpecExaminationService: GenericService, private toastr: ToastrService) {
    this.relativeUrlAllReferralsForSpecExamination = '/patient/ref-spec-examination';
    this.xHtmlContetntForReferralsForSpecExamination = 'Loading referrals for specialist examination...';
   }

  ngOnInit() {
    if (this.idOfPatientNum) {
      this.relativeUrlAllReferralsForSpecExamination += '/' + this.idOfPatientNum;
    }
    this.getAllReferralsForSpecExamination();
  }

  getAllReferralsForSpecExamination () {
    this.referralForSpecExaminationService.get<string>(this.relativeUrlAllReferralsForSpecExamination).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
              // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
             this.xHtmlContetntForReferralsForSpecExamination = this.referralForSpecExaminationService
                                            .replaceAllBackSlash(receivedXml.substring(1, receivedXml.length - 1));
              // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove
              this.toastr.success('Referrals for specialist examination are successfully loaded!');
          }
          else {
            this.xHtmlContetntForReferralsForSpecExamination = 'Problem with loading of referrals for specialist examination!';
            this.toastr.error('Problem with loading of referrals for specialist examination!');
          }
      },
      (err) => {
        this.xHtmlContetntForReferralsForSpecExamination = 'Problem with loading of referrals for specialist examination!';
        this.toastr.error('Problem with loading of referrals for specialist examination!');
      }
    );
  }


}
