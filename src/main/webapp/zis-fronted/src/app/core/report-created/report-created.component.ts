import { Component, OnInit } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-report-created',
  templateUrl: './report-created.component.html',
  styleUrls: ['./report-created.component.css']
})
export class ReportCreatedComponent implements OnInit {
  xHtmlContetntForReportCreated = 'Loading report...'; // dobijen koriscenjem xsl transformacije

  private relativeUrlGetReport: string;

  private relativeUrlMakeDoctorReceipt: string;
  private relativeUrlMakeReferralForLab: string;
  private relativeUrlMakeReferralForSpecExamination: string;

  private diagnosis: string;
  private idOfPatientNum: string;


  constructor(private reportService: GenericService, private route: ActivatedRoute, private router: Router,
             private toastr: ToastrService) {
    this.relativeUrlGetReport = '/doctor/get-report';

    this.relativeUrlMakeDoctorReceipt = '/make-doctor-receipt';
    this.relativeUrlMakeReferralForLab = '/make-referral-for-lab';
    this.relativeUrlMakeReferralForSpecExamination = '/make-referral-for-spec-exam';
  }

  ngOnInit() {
    if (this.route.snapshot.params['diagnosis']) {
      this.diagnosis = this.route.snapshot.params['diagnosis'];
    }

    if (this.route.snapshot.params['idOfReportNum']) {
      const idOfReportNUm = this.route.snapshot.params['idOfReportNum'];
      this.relativeUrlGetReport += '/' + idOfReportNUm;

      this.getReportCreated();
    }

    if (this.route.snapshot.params['idOfPatientNum']) {
      this.idOfPatientNum = this.route.snapshot.params['idOfPatientNum'];
    }
  }

  getReportCreated() {
    this.reportService.get<string>(this.relativeUrlGetReport).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
               // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
               this.xHtmlContetntForReportCreated = this.reportService.replaceAllBackSlash(receivedXml.substring(1,
                receivedXml.length - 1));
              // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove

          }
          else {
            this.xHtmlContetntForReportCreated = 'Problem with loading of report!';
            this.toastr.error('Problem with loading of report!');
          }
      },
      (err) => {
        this.xHtmlContetntForReportCreated = 'Problem with loading of report!';
        this.toastr.error('Problem with loading of report!');
      }
    );
  }

  finishReview() {
    this.router.navigate(['/doctor']);
  }
}
