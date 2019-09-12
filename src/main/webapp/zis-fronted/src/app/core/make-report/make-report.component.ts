import { Component, OnInit } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';

@Component({
  selector: 'app-make-report',
  templateUrl: './make-report.component.html',
  styleUrls: ['./make-report.component.css']
})
export class MakeReportComponent implements OnInit {
  private editorAnamnesis;
  private editorTherapy;
  /*public model = {
    editorData: '' // '<p>Hello, world!</p>'
  };*/

  config = {
    toolbar: {
        items: [ 'bold', 'italic', '|', 'link', '|', 'undo', 'redo' ],

        viewportTopOffset: 30
    } // ,
    // placeholder: 'Anamnesis...'
  };

  relativeUrlMakeReport: string;
  relativeUrlReportCreated: string;

  idOfPatientNum: string;

  private diagnosis: string;


  constructor(private reportService: GenericService, private route: ActivatedRoute, private router: Router,
              private toastr: ToastrService) {

        this.relativeUrlMakeReport = '/doctor/make-report';

        this.relativeUrlReportCreated = '/report-created';

        this.diagnosis = '';
  }

  ngOnInit() {
    if (this.route.snapshot.params['idOfPatientNum']) {
      this.idOfPatientNum = this.route.snapshot.params['idOfPatientNum'];
      this.relativeUrlMakeReport += '/' + this.idOfPatientNum;
      // this.relativeUrlReportCreated += '/' + this.idOfPatientNum;
    }

    ClassicEditor
            .create( document.querySelector( '#id_anamnesis' ), this.config)
            .then( editor => {
              this.editorAnamnesis = editor;
              console.log( 'Editor Anamnesis was initialized', this.editorAnamnesis );
            })
            .catch( error => {
                console.error( error );
            } );

    ClassicEditor
            .create( document.querySelector( '#id_therapy' ), this.config)
            .then( editor => {
              this.editorTherapy = editor;
              console.log( 'Editor Therapy was initialized', this.editorTherapy );
            })
            .catch( error => {
                console.error( error );
            } );
  }

  prepareTextAndLinks(str: string) {
    str = str.replace('<p>', '').replace('</p>', '').replace(/&nbsp;/g, '').trim();
    const tokens: string[] = str.split(' ');
    const newTokens = [];
    tokens.forEach(token => {
      if (token !== '' && token !== '<a') {
        if (token.includes('href')) {
          let newToken = '<link ' + token;
          newToken = newToken.replace(/href=".*"/, function (x) {
                                return x.replace('href', 'id') + ' ' + x;
                          });
                          newToken = newToken.replace(/>.*</, '/><');
                          newToken = newToken.replace('</a>', '');
                          token = newToken;
        }
        newTokens.push(token);
      }
    });
    return newTokens.join(' ');
  }

  makeReport() {
    this.diagnosis = this.diagnosis.trim();
    if (!this.diagnosis || this.diagnosis === '') {
      this.toastr.error('You did not fill in the diagnosis field!');
      return;
    }

    let anamnesis = this.editorAnamnesis.getData();
    anamnesis = this.prepareTextAndLinks(anamnesis);
    if (!anamnesis || anamnesis === '') {
      this.toastr.error('You did not fill in the anamnesis field!');
      return;
    }

    let therapy = this.editorTherapy.getData();
    therapy = this.prepareTextAndLinks(therapy);
    if (!therapy || therapy === '') {
      this.toastr.error('You did not fill in the therapy field!');
      return;
    }

    const xml = `<report_dto xmlns="http://www.svj.com/zis/dto">
                  <dijagnoza>${this.diagnosis}</dijagnoza>
                  <anamneza>${anamnesis}</anamneza>
                  <terapija>${therapy}</terapija>
                </report_dto>`;

    this.reportService.post(this.relativeUrlMakeReport, xml).subscribe(
      (newReportIdNum: string) => {
        this.router.navigate([this.relativeUrlReportCreated, this.diagnosis, newReportIdNum, this.idOfPatientNum]);
        this.toastr.success('The report was successfully created!');
      },
      err => this.toastr.error('The report was not successfully created!')
    );
  }

}
