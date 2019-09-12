import { Component, OnInit, Input } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { GenericService } from '../services/generic/generic.service';

declare const $: any;

@Component({
  selector: 'app-make-referral-for-spec-exam',
  templateUrl: './make-referral-for-spec-exam.component.html',
  styleUrls: ['./make-referral-for-spec-exam.component.css']
})
export class MakeReferralForSpecExamComponent implements OnInit {
  @Input() idOfPatientNum: string;

  private relativeUrlGetSpecialists: string;
  private relativeUrlMakeReferralForSpecExamination: string;

  xHtmlContetntForSpecialists = 'Loading specialists...'; // dobijen koriscenjem xsl transformacije

  zdravstvenaUstanovaKojaSalje: string;
  zdravstvenaUstanovaKojaPrima: string;
  lekarovPotpis: string;
  pecat: string;


  constructor(private doctorService: GenericService, private toastr: ToastrService) {
    this.relativeUrlGetSpecialists = '/doctor/get-specialists';
    this.relativeUrlMakeReferralForSpecExamination = '/doctor/make-referral-for-spec-examination';

    this.zdravstvenaUstanovaKojaSalje = '';
    this.zdravstvenaUstanovaKojaPrima = '';
    this.lekarovPotpis = '';
    this.pecat = '';

    this.getSpecialists();
  }

  ngOnInit() {
    this.relativeUrlMakeReferralForSpecExamination += '/' + this.idOfPatientNum;
  }

  getSpecialists() {
    this.doctorService.get<string>(this.relativeUrlGetSpecialists).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
               // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
               this.xHtmlContetntForSpecialists = this.doctorService.replaceAllBackSlash(receivedXml.substring(1,
                receivedXml.length - 1));
              // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove

          }
          else {
            this.xHtmlContetntForSpecialists = 'Problem with loading of specialists!';
            this.toastr.error('Problem with loading of specialists!');
          }
      },
      (err) => {
        this.xHtmlContetntForSpecialists = 'Problem with loading of specialists!';
        this.toastr.error('Problem with loading of specialists!');
      }
    );
  }

  makeReferralForSpecExamination() {
    if ($('#id_select_specialist').length === 0) {
      this.toastr.error('You did not choose specialist!');
      return;
    }
    const specijalistaId = $('#id_select_specialist').val();

    if (!this.zdravstvenaUstanovaKojaSalje || this.zdravstvenaUstanovaKojaSalje.trim() === '') {
      this.toastr.error('You did not fill in the health institution that sends field!');
      return;
    }

    if (!this.zdravstvenaUstanovaKojaPrima || this.zdravstvenaUstanovaKojaPrima.trim() === '') {
      this.toastr.error('You did not fill in the health institution receiving field!');
      return;
    }

    if (!this.lekarovPotpis || this.lekarovPotpis.trim() === '') {
      this.toastr.error('You did not fill in the doctor\'s signature field!');
      return;
    }

    if (!this.pecat || this.pecat.trim() === '') {
      this.toastr.error('You did not fill in the name of seal field!');
      return;
    }

    const xml = `<uput_za_specijalisticki_pregled_dto xmlns="http://www.svj.com/zis/dto">
                  <zdravstvena_ustanova_koja_salje>${this.zdravstvenaUstanovaKojaSalje.trim()}</zdravstvena_ustanova_koja_salje>
                  <zdravstvena_ustanova_koja_prima>${this.zdravstvenaUstanovaKojaPrima.trim()}</zdravstvena_ustanova_koja_prima>
                  <lekarov_potpis>${this.lekarovPotpis.trim()}</lekarov_potpis>
                  <pecat>${this.pecat.trim()}</pecat>
                  <specijalista id="${specijalistaId.trim()}"/>
                </uput_za_specijalisticki_pregled_dto>`;

    this.doctorService.post(this.relativeUrlMakeReferralForSpecExamination, xml).subscribe(
      () => this.toastr.success('The referral for spec examination was successfully created!'),
      err => this.toastr.error('The referral for spec examination was not successfully created!')
    );
  }

}
