import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';

declare const $: any;

@Component({
  selector: 'app-choose-doctor',
  templateUrl: './choose-doctor.component.html',
  styleUrls: ['./choose-doctor.component.css']
})
export class ChooseDoctorComponent implements OnInit {

  @Input()
  xHtmlContetntForSelectedDoctor: string; // dobijen koriscenjem xsl transformacije

  xHtmlContetntForDoctors: string; // dobijen koriscenjem xsl transformacije
  relativeUrlAllDoctors: string;
  relativeUrlSelectDoctor: string;
  // idOfNewDoctor: string;

  @Output()
  selectedDoctorEvent = new EventEmitter();

  constructor(private doctorService: GenericService, private toastr: ToastrService) {
    this.xHtmlContetntForDoctors = 'Loading doctors...';
    this.relativeUrlAllDoctors = '/patient/all-doctors';
    this.relativeUrlSelectDoctor = '/patient/select-doctor?id-of-doctor=';
  }

  ngOnInit() {
    this.getAllDoctors();
  }

  /*prepareEvenListeners() {
    const that = this;

    document.querySelectorAll('a.doctor').forEach(d => {
      d.addEventListener('click', function(e) {
        e.preventDefault();
        const idOfNewDoctor = d.getAttribute('href');
        that.selectDoctor(idOfNewDoctor);
      });
    });
  }*/

  getAllDoctors () {
    this.doctorService.get<string>(this.relativeUrlAllDoctors).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
               // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
               this.xHtmlContetntForDoctors = this.doctorService.replaceAllBackSlash(receivedXml.substring(1,
                receivedXml.length - 1));
              // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove
              // this.idOfNewDoctor = '';
          }
          else {
            this.xHtmlContetntForDoctors = 'Problem with loading of doctors!';
            this.toastr.error('Problem with loading of doctors!');
          }
      },
      (err) => {
        this.xHtmlContetntForDoctors = 'Problem with loading of doctors!';
        this.toastr.error('Problem with loading of doctors!');
      }
    );
  }

  selectDoctor() {
    const idOfNewDoctor = $('#id_select_doctor').val();
    if (idOfNewDoctor && idOfNewDoctor !== '') {
      this.doctorService.putById(this.relativeUrlSelectDoctor, idOfNewDoctor).subscribe(
        () => {
            this.selectedDoctorEvent.emit();
            this.toastr.success('You have successfully chosen a doctor!');
            this.getAllDoctors();
        },
        (err) => this.toastr.error('You did not successfully choose a doctor!')
      );
    }
    else {
      this.toastr.error('You did not choose a doctor!');
    }
  }

}
