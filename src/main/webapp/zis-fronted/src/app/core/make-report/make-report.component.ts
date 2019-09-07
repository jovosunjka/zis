import { Component, OnInit } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-make-report',
  templateUrl: './make-report.component.html',
  styleUrls: ['./make-report.component.css']
})
export class MakeReportComponent implements OnInit {

  relativeUrlMakeReport: string;

  idOfPatientNum: string;

  private diagnosis: string;
  private anamnesis: string;
  private therapy: string;

  constructor(private reportService: GenericService, private route: ActivatedRoute,
              private toastr: ToastrService) {

        this.relativeUrlMakeReport = '/doctor/make-report';

        this.diagnosis = '';
        this.anamnesis = '';
        this.therapy = '';
  }

  ngOnInit() {
    if (this.route.snapshot.params['idOfPatientNum']) {
      this.idOfPatientNum = this.route.snapshot.params['idOfPatientNum'];
      this.relativeUrlMakeReport += '/' + this.idOfPatientNum;
    }
  }

  makeReport() {
    const xml = `<report_dto xmlns="http://www.svj.com/zis/dto">
                  <dijagnoza>${this.diagnosis}</dijagnoza>
                  <anamneza>${this.anamnesis}</anamneza>
                  <terapija>${this.therapy}</terapija>
                </report_dto>`;

    this.reportService.post(this.relativeUrlMakeReport, xml).subscribe(
      () => this.toastr.success('The report was successfully created!'),
      err => this.toastr.error('The report was not successfully created!')
    );
  }

}
