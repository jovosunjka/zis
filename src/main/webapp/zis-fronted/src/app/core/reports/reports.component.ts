import { Component, OnInit } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {
  xHtmlContetntForReports: string; // dobijen koriscenjem xsl transformacije
  relativeUrlAllReports: string;

  constructor(private reportService: GenericService, private toastr: ToastrService) {
    this.relativeUrlAllReports = '/patient/all-reports';
    this.xHtmlContetntForReports = 'Loading reports...';
   }

  ngOnInit() {
    this.getAllReports();
  }

  getAllReports () {
    this.reportService.get<string>(this.relativeUrlAllReports).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
              this.xHtmlContetntForReports = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
              this.toastr.success('Reports are successfully loaded!');
          }
          else {
            this.xHtmlContetntForReports = 'Problem with loading of reports!';
            this.toastr.error('Problem with loading of reports!');
          }
      },
      (err) => {
        this.xHtmlContetntForReports = 'Problem with loading of reports!';
        this.toastr.error('Problem with loading of reports!');
      }
    );
  }

}
