import { Component, OnInit } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-referrals-for-lab',
  templateUrl: './referrals-for-lab.component.html',
  styleUrls: ['./referrals-for-lab.component.css']
})
export class ReferralsForLabComponent implements OnInit {
  xHtmlContetntForReferralsForLab: string; // dobijen koriscenjem xsl transformacije
  relativeUrlAllReferralsForLab: string;

  constructor(private referralsForLabService: GenericService, private toastr: ToastrService) {
    this.relativeUrlAllReferralsForLab = '/patient/ref-for-lab';
    this.xHtmlContetntForReferralsForLab = 'Loading referrals for lab...';
   }

  ngOnInit() {
    this.getAllReferralsForLab();
  }

  getAllReferralsForLab () {
    this.referralsForLabService.get<string>(this.relativeUrlAllReferralsForLab).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
              this.xHtmlContetntForReferralsForLab = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
              this.toastr.success('Referrals for lab are successfully loaded!');
          }
          else {
            this.xHtmlContetntForReferralsForLab = 'Problem with loading of referrals for lab!';
            this.toastr.error('Problem with loading of referrals for lab!');
          }
      },
      (err) => {
        this.xHtmlContetntForReferralsForLab = 'Problem with loading of referrals for lab!';
        this.toastr.error('Problem with loading of referrals for lab!');
      }
    );
  }
}
