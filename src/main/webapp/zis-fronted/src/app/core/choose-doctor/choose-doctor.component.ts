import { Component, OnInit } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-choose-doctor',
  templateUrl: './choose-doctor.component.html',
  styleUrls: ['./choose-doctor.component.css']
})
export class ChooseDoctorComponent implements OnInit {
  xHtmlContetnt: string; // dobijen koriscenjem xsl transformacije
  relativeUrlAllDoctors: string;
  relativeUrlSelectDoctor: string;
  idOfNewDoctor: string;

  constructor(private doctorService: GenericService, private toastr: ToastrService) {
    this.xHtmlContetnt = 'Loading doctors...';
    this.relativeUrlAllDoctors = '/patient/all-doctors';
    this.relativeUrlSelectDoctor = '/patient/select-doctor?id-of-doctor=';
  }

  ngOnInit() {
    this.getAllDoctors();
  }

  getAllDoctors () {
    this.doctorService.get<string>(this.relativeUrlAllDoctors).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
              this.xHtmlContetnt = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
              this.toastr.success('Doctors are successfully loaded!');
          }
          else {
            this.toastr.error('Problem with loading of doctors!');
          }
      },
      (err) => this.toastr.error('Problem with loading of doctors!')
    );
  }

  selectDoctor() {
    if (this.idOfNewDoctor && this.idOfNewDoctor !== '') {
      this.doctorService.putById(this.relativeUrlSelectDoctor, this.idOfNewDoctor).subscribe(
        () => {
          this.idOfNewDoctor = '';
          this.toastr.success('You have successfully chosen a doctor!');
        },
        (err) => this.toastr.error('You did not successfully choose a doctor!')
      );
    }
    else {
      this.toastr.error('You did not enter the id of the doctor!');
    }
  }

}
