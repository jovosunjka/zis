import { Component, OnInit, Input } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { GenericService } from '../services/generic/generic.service';

declare const $: any;

@Component({
  selector: 'app-make-referral-for-lab',
  templateUrl: './make-referral-for-lab.component.html',
  styleUrls: ['./make-referral-for-lab.component.css']
})
export class MakeReferralForLabComponent implements OnInit {
  @Input() idOfPatientNum: string;

  private relativeUrlMakeReferralForLab: string;

  zdravstvenaUstanovaKojaSaljeLab: string;
  zdravstvenaUstanovaKojaPrimaLab: string;
  klinickaDijagnoza: string;
  kadJeUzetMaterijalDatum: string;
  kadJeUzetMaterijalVreme: string;
  tipPregleda: string;
  lekarovPotpisLab: string;
  pecatLab: string;


  constructor(private doctorService: GenericService, private toastr: ToastrService) {
    this.relativeUrlMakeReferralForLab = '/doctor/make-referral-for-lab';

    this.zdravstvenaUstanovaKojaSaljeLab = '';
    this.zdravstvenaUstanovaKojaPrimaLab = '';
    this.klinickaDijagnoza = '';
    this.tipPregleda = '';
    this.lekarovPotpisLab = '';
    this.pecatLab = '';

    const currentDateTime = new Date();
    let currentDateStr = '' + currentDateTime.getDate();
    if (currentDateStr.length === 1) {
      currentDateStr = '0' + currentDateStr;
    }

    let monthStr = '' + (currentDateTime.getMonth() + 1);
    if (monthStr.length === 1) {
      monthStr = '0' + monthStr;
    }

    let hoursStr = '' + currentDateTime.getHours();
    if (hoursStr.length === 1) {
      hoursStr = '0' + hoursStr;
    }

    let minutesStr = '' + currentDateTime.getMinutes();
    if (minutesStr.length === 1) {
      minutesStr = '0' + minutesStr;
    }

    this.kadJeUzetMaterijalDatum = currentDateTime.getFullYear() + '-' + monthStr + '-' + currentDateStr;
    this.kadJeUzetMaterijalVreme = hoursStr + ':' + minutesStr;
   }

  ngOnInit() {
    this.relativeUrlMakeReferralForLab += '/' + this.idOfPatientNum;
  }

  makeReferralForLab() {
    if (!this.zdravstvenaUstanovaKojaSaljeLab || this.zdravstvenaUstanovaKojaSaljeLab.trim() === '') {
      this.toastr.error('You did not fill in the health institution that sends field!');
      return;
    }

    if (!this.zdravstvenaUstanovaKojaPrimaLab || this.zdravstvenaUstanovaKojaPrimaLab.trim() === '') {
      this.toastr.error('You did not fill in the health institution receiving field!');
      return;
    }

    if (!this.klinickaDijagnoza || this.klinickaDijagnoza.trim() === '') {
      this.toastr.error('You did not fill in the clinical diagnosis field!');
      return;
    }

    if (!this.kadJeUzetMaterijalDatum || this.kadJeUzetMaterijalDatum.trim() === '' ||
        !this.kadJeUzetMaterijalVreme || this.kadJeUzetMaterijalVreme.trim() === '') {
      this.toastr.error('Invalid date or time!');
      return;
    }

    let kadJeUzetMaterijalVreme = this.kadJeUzetMaterijalVreme;
    if (kadJeUzetMaterijalVreme.length === 5) {
      kadJeUzetMaterijalVreme += ':00';
    }
    const kadJeUzetMaterijal = this.kadJeUzetMaterijalDatum + 'T' + kadJeUzetMaterijalVreme;

    if (!this.tipPregleda || this.tipPregleda.trim() === '') {
      this.toastr.error('You did not fill in the review type field!');
      return;
    }

    if (!this.lekarovPotpisLab || this.lekarovPotpisLab.trim() === '') {
      this.toastr.error('You did not fill in the doctor\'s signature field!');
      return;
    }

    if (!this.pecatLab || this.pecatLab.trim() === '') {
      this.toastr.error('You did not fill in the name of seal field!');
      return;
    }

    const xml = `<uput_za_laboratoriju_dto xmlns="http://www.svj.com/zis/dto">
                  <zdravstvena_ustanova_koja_salje>${this.zdravstvenaUstanovaKojaSaljeLab.trim()}</zdravstvena_ustanova_koja_salje>
                  <zdravstvena_ustanova_koja_prima>${this.zdravstvenaUstanovaKojaPrimaLab.trim()}</zdravstvena_ustanova_koja_prima>
                  <klinicka_dijagnoza>${this.klinickaDijagnoza.trim()}</klinicka_dijagnoza>
                  <kad_je_uzet_materijal>${kadJeUzetMaterijal}</kad_je_uzet_materijal>
                  <tip_pregleda>${this.tipPregleda.trim()}</tip_pregleda>
                  <lekarov_potpis>${this.lekarovPotpisLab.trim()}</lekarov_potpis>
                  <pecat>${this.pecatLab.trim()}</pecat>
                </uput_za_laboratoriju_dto>`;

    this.doctorService.post(this.relativeUrlMakeReferralForLab, xml).subscribe(
      () => this.toastr.success('The referral for lab was successfully created!'),
      err => this.toastr.error('The referral for lab was not successfully created!')
    );
  }

}
