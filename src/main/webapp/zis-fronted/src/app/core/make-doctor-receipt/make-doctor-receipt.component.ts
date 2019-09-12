import { Component, OnInit, Input } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute } from '@angular/router';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';

declare const $: any;

@Component({
  selector: 'app-make-doctor-receipt',
  templateUrl: './make-doctor-receipt.component.html',
  styleUrls: ['./make-doctor-receipt.component.css']
})
export class MakeDoctorReceiptComponent implements OnInit {

  @Input() diagnosis: string;
  @Input() idOfPatientNum: string;

  private editorRp;
  /*public model = {
    editorData: '' // '<p>Hello, world!</p>'
  };*/

  config = {
    toolbar: {
        items: [ 'bold', 'italic', '|', 'link', '|', 'undo', 'redo' ],

        viewportTopOffset: 30
    } // ,
    // placeholder: 'Rp...'
  };

  nazivZdrastveneUstanove: string;
  drzava: string;
  potpisLekara: string;
  // nazivLeka: string;
  // sifraLeka: string;
  // dijagnoza: string;
  redniBroj: string;
  kolicina: string;

  relativeUrlMakeDoctorReceipt: string;
  relativeUrlGetMedicaments: string;

  xHtmlContetntForMedicaments = 'Loading medicaments...'; // dobijen koriscenjem xsl transformacije


  constructor(private doctorService: GenericService, private toastr: ToastrService) {
    this.relativeUrlMakeDoctorReceipt = '/doctor/make-doctor-receipt';
    this.relativeUrlGetMedicaments = '/doctor/get-medicaments';
  }

  ngOnInit() {

    this.relativeUrlMakeDoctorReceipt += '/' + this.idOfPatientNum;
    this.relativeUrlGetMedicaments += '?diagnosis=' + this.diagnosis;

    this.getMedicaments();

    // this.dijagnoza = '';
    this.redniBroj = '';
    this.kolicina = '';
    this.nazivZdrastveneUstanove = '';
    this.drzava = '';

    ClassicEditor
            .create( document.querySelector( '#id_rp' ), this.config)
            .then( editor => {
              this.editorRp = editor;
              console.log( 'Editor Therapy was initialized', this.editorRp );
            })
            .catch( error => {
                console.error( error );
            } );
  }

  getMedicaments() {
    this.doctorService.get<string>(this.relativeUrlGetMedicaments).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
               // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
               this.xHtmlContetntForMedicaments = this.doctorService.replaceAllBackSlash(receivedXml.substring(1,
                receivedXml.length - 1));
              // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove

          }
          else {
            this.xHtmlContetntForMedicaments = 'Problem with loading of medicaments!';
            this.toastr.error('Problem with loading of medicaments!');
          }
      },
      (err) => {
        this.xHtmlContetntForMedicaments = 'Problem with loading of medicaments!';
        this.toastr.error('Problem with loading of medicaments!');
      }
    );
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

  makeDoctorReceipt() {
    /*if (!this.sifraLeka || this.sifraLeka.trim() === '') {
      this.toastr.error('You did not fill in the medicament code field!');
      return;
    }

    if (!this.nazivLeka || this.nazivLeka.trim() === '') {
      this.toastr.error('You did not fill in the medicament name field!');
      return;
    }*/

    if ($('#id_select_medicaments').length === 0) {
      this.toastr.error('You did not choose medicament!');
      return;
    }
    const lek = $('#id_select_medicaments').val();
    const lekTokens = lek.split(',');
    const sifraLeka =  lekTokens[0];
    const nazivLeka = lekTokens[1];

    /*if (!this.dijagnoza || this.dijagnoza.trim() === '') {
      this.toastr.error('You did not fill in the diagnosis field!');
      return;
    }*/

    if (!this.redniBroj || this.redniBroj.trim() === '') {
      this.toastr.error('You did not fill in the serial number field!');
      return;
    }

    if (!this.kolicina || this.kolicina.trim() === '') {
      this.toastr.error('You did not fill in the quantity field!');
      return;
    }

    if (!this.nazivZdrastveneUstanove || this.nazivZdrastveneUstanove.trim() === '') {
      this.toastr.error('You did not fill in the name of the health institution field!');
      return;
    }

    if (!this.drzava || this.drzava.trim() === '') {
      this.toastr.error('You did not fill in the country field!');
      return;
    }

    let rp = this.editorRp.getData();
    rp = this.prepareTextAndLinks(rp);

    const xml = `<doctor_receipt_dto xmlns="http://www.svj.com/zis/dto">
                  <ustanova>
                      <naziv_zdrastvene_ustanove>${this.nazivZdrastveneUstanove.trim()}</naziv_zdrastvene_ustanove>
                      <drzava>${this.drzava.trim()}</drzava>
                  </ustanova>
                  <potpis_lekara>${this.potpisLekara.trim()}</potpis_lekara>
                  <propisani_lek>
                      <naziv>${nazivLeka.trim()}</naziv>
                      <sifra>${sifraLeka.trim()}</sifra>
                  </propisani_lek>
                  <dijagnoza>${this.diagnosis.trim()}</dijagnoza>
                  <redni_broj>${this.redniBroj.trim()}</redni_broj>
                  <kolicina>${this.kolicina.trim()}</kolicina>
                  <rp>${rp}</rp>
                </doctor_receipt_dto>`;

      this.doctorService.post(this.relativeUrlMakeDoctorReceipt, xml).subscribe(
        () => this.toastr.success('The doctor\'s receipt was successfully created!'),
        err => this.toastr.error('The doctor\'s receipt was not successfully created!')
      );
  }

}
