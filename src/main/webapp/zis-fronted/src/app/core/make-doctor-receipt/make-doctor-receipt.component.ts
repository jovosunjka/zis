import { Component, OnInit } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-make-doctor-receipt',
  templateUrl: './make-doctor-receipt.component.html',
  styleUrls: ['./make-doctor-receipt.component.css']
})
export class MakeDoctorReceiptComponent implements OnInit {

  nazivZdrastveneUstanove: string;
  drzava: string;
  potpisLekara: string;
  nazivLeka: string;
  sifraLeka: string;
  dijagnoza: string;
  redniBroj: string;
  kolicina: string;
  rp: string;

  relativeUrlMakeDoctorReceipt: string;

  idOfPatientNum: string;


  constructor(private doctorReceiptService: GenericService, private route: ActivatedRoute,
              private toastr: ToastrService) {
    this.relativeUrlMakeDoctorReceipt = '/doctor/make-doctor-receipt';
  }

  ngOnInit() {
    if (this.route.snapshot.params['idOfPatientNum']) {
      this.idOfPatientNum = this.route.snapshot.params['idOfPatientNum'];
      this.relativeUrlMakeDoctorReceipt += '/' + this.idOfPatientNum;
    }
  }

  makeDoctorReceipt() {
    const xml = `<doctor_receipt_dto xmlns="http://www.svj.com/zis/dto">
                  <ustanova>
                      <naziv_zdrastvene_ustanove>${this.nazivZdrastveneUstanove}</naziv_zdrastvene_ustanove>
                      <drzava>${this.drzava}</drzava>
                  </ustanova>
                  <potpis_lekara>${this.potpisLekara}</potpis_lekara>
                  <propisani_lek>
                      <naziv>${this.nazivLeka}</naziv>
                      <sifra>${this.sifraLeka}</sifra>
                  </propisani_lek>
                  <dijagnoza>${this.dijagnoza}</dijagnoza>
                  <redni_broj>${this.redniBroj}</redni_broj>
                  <kolicina>${this.kolicina}</kolicina>
                  <rp>${this.rp}</rp>
                </lekarski_recept>`;

      this.doctorReceiptService.post(this.relativeUrlMakeDoctorReceipt, xml).subscribe(
        () => this.toastr.success('The doctor\'s receipt was successfully created!'),
        err => this.toastr.error('The doctor\'s receipt was not successfully created!')
      );
  }

}
