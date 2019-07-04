import { Component, OnInit, ElementRef, ViewChild, AfterViewInit } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute } from '@angular/router';

declare var $: any;

@Component({
  selector: 'app-edit-health-card',
  templateUrl: './edit-health-card.component.html',
  styleUrls: ['./edit-health-card.component.css']
})
export class EditHealthCardComponent implements OnInit {

  xHtmlContetntForBasicInformations: string; // dobijen koriscenjem xsl transformacije
  relativeUrlBasicInformations: string;
  relativeUrlBasicInformationsEdit: string;

  idOfPatientNum: string;

  constructor(private basicInformationsService: GenericService, private route: ActivatedRoute,
               private toastr: ToastrService) {
    this.relativeUrlBasicInformations = '/doctor/health-card_basic-info';
    this.relativeUrlBasicInformationsEdit = '/doctor/basic-info-edit';
    this.xHtmlContetntForBasicInformations = 'Loading basic informations...';
   }

  ngOnInit() {
    if (this.route.snapshot.params['numberOfHealthCard']) {
      this.idOfPatientNum = this.route.snapshot.params['numberOfHealthCard'];
      this.relativeUrlBasicInformations += '/' + this.idOfPatientNum;
      this.relativeUrlBasicInformationsEdit += '/' + this.idOfPatientNum;
    }
    this.getBasicInformations();
  }

  getBasicInformations () {
    this.basicInformationsService.get<string>(this.relativeUrlBasicInformations).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
              // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
              this.xHtmlContetntForBasicInformations = this.basicInformationsService.replaceAllBackSlash(receivedXml.substring(1,
                receivedXml.length - 1));
              // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove
              this.toastr.success('Basic informations are successfully loaded!');
          }
          else {
            this.xHtmlContetntForBasicInformations = 'Problem with loading of basic informations!';
            this.toastr.error('Problem with loading of basic informations!');
          }
      },
      (err) => {
        this.xHtmlContetntForBasicInformations = 'Problem with loading of basic informations!';
        this.toastr.error('Problem with loading of basic informations!');
      }
    );
  }

  save() {
    const jmbg = $('#jmbg').val();
    const lbo = $('#lbo').val();
    const firstName = $('#firstName').val();
    const lastName = $('#lastName').val();
    const nameOfOneParent = $('#nameOfOneParent').val();
    const dateOfBirth = $('#dateOfBirth').val();
    const street = $('#street').val();
    const number = $('#number').val();
    const city = $('#city').val();
    const township = $('#township').val();
    const phoneNumber = $('#phoneNumber').val();
    const our = $('#our').val();
    const sex = $('#sex').val();
    const maritalStatus = $('#maritalStatus').val();
    const reasonForExemptionFromParticipation = $('#reasonForExemptionFromParticipation').val();


    const xml = `<basic_info_dto xmlns="http://www.svj.com/zis/dto">
                    <jmbg>${jmbg}</jmbg>
                    <lbo>${lbo}</lbo>
                    <ime>${firstName}</ime>
                    <prezime>${lastName}</prezime>
                    <ime_jednog_roditelja>${nameOfOneParent}</ime_jednog_roditelja>
                    <datum_rodjenja>${dateOfBirth}</datum_rodjenja>
                    <ulica>${street}</ulica>
                    <broj>${number}</broj>
                    <mesto>${city}</mesto>
                    <opstina>${township}</opstina>
                    <telefon>${phoneNumber}</telefon>
                    <our>${our}</our>
                    <pol>${sex}</pol>
                    <bracno_stanje>${maritalStatus}</bracno_stanje>
                    <osnov_oslobadjanja_od_participacije>${reasonForExemptionFromParticipation}</osnov_oslobadjanja_od_participacije>
                </basic_info_dto>`;
    this.basicInformationsService.put(this.relativeUrlBasicInformationsEdit, xml).subscribe(
      () => this.toastr.success('Basic informations has been successfully altered!'),
      err => this.toastr.error('Basic informations have not been altered successfully!')
    );
  }

}
