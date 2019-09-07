import { Component, OnInit } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';

declare const $: any;

@Component({
  selector: 'app-nurse-page',
  templateUrl: './nurse-page.component.html',
  styleUrls: ['./nurse-page.component.css']
})
export class NursePageComponent implements OnInit {

  private relativeUrlGetReviews: string;
  private relativeUrlEditReviews: string;
  private relativeUrlAllDoctors: string;

  xHtmlContetntForDoctors = 'Loading doctors...'; // dobijen koriscenjem xsl transformacije
  xHtmlContetntForReviews = ''; // dobijen koriscenjem xsl transformacije

  constructor(private reviewService: GenericService, private toastr: ToastrService) {
    this.relativeUrlGetReviews = '/nurse/get-reviews?idNumOfDoctor=';
    this.relativeUrlEditReviews = '/nurse/edit-reviews';
    this.relativeUrlAllDoctors = '/nurse/all-doctors';
  }

  ngOnInit() {
    this.getAllDoctors();
    // this.getReviews();
  }

  getAllDoctors () {
    this.reviewService.get<string>(this.relativeUrlAllDoctors).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
               // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
               this.xHtmlContetntForDoctors = this.reviewService.replaceAllBackSlash(receivedXml.substring(1,
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

  getReviews() {
    this.xHtmlContetntForReviews = 'Loading reviews...';
    const idOfDoctor = $('#id_select_doctor').val();
    const tokens = idOfDoctor.split('/');
    const idNumOfDoctor = tokens[tokens.length - 1];
    this.reviewService.get<string>(this.relativeUrlGetReviews + idNumOfDoctor).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
               // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
               this.xHtmlContetntForReviews = this.reviewService.replaceAllBackSlash(receivedXml.substring(1,
                receivedXml.length - 1));
              // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove
              // this.idOfNewDoctor = '';
          }
          else {
            this.xHtmlContetntForReviews = 'Problem with loading of reviews!';
            this.toastr.error('Problem with loading of reviews!');
          }
      },
      (err) => {
        this.xHtmlContetntForReviews = 'Problem with loading of reviews!';
        this.toastr.error('Problem with loading of reviews!');
      }
    );
  }

  add() {
    if ($('#id_table_reviews').length && $('#id_select_doctor').length) {
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

      const currentDate = currentDateTime.getFullYear() + '-' + monthStr + '-' + currentDateStr;
      const currentTime = hoursStr + ':' + minutesStr;

      $('#id_table_reviews').append(
        `<tr>
			    <td class="reviewId">Will be generated</td>
			    <td>Unkonwn</td>
			    <td>Unknown</td>
			    <td><input type="date" value="${currentDate}"/></td>
			    <td><input type="time" value="${currentTime}"/></td>
			    <td><button class="btn btn-danger" onclick="this.parentNode.parentNode.remove()">Remove</button></td>
		    </tr>`
      );
    }
  }

  save() {
    const idOfDoctor = $('#id_select_doctor').val();
    if ($('#id_table_reviews').length && idOfDoctor && idOfDoctor !== '') {
      let xml = '<reviews_dto xmlns="http://www.svj.com/zis/dto">';
      xml += '<doctor id="' + idOfDoctor + '" /> <reviews>';
      let invalidDateOrTime = false;
      $('#id_table_reviews tr').each(function(index) {
        if (index > 0) {
          const review = $(this).children('.reviewId')[0];
          const reviewId = $(review).text();
          xml += '<review id="' + reviewId + '">';
          const inputs = $($(this).children('td')).children('input');
          const dateStr = $(inputs[0]).val();
          if (dateStr.trim() === '') {
            invalidDateOrTime = true;
          }
          let timeStr = $(inputs[1]).val();
          if (timeStr.trim() === '') {
            invalidDateOrTime = true;
          } else if (timeStr.length === 5) {
            timeStr += ':00';
          }

          const dateAndTime = dateStr + 'T' + timeStr;
          xml += '<dateAndTime>' + dateAndTime + '</dateAndTime>';
          xml += '</review>';
        }
      });

      if (invalidDateOrTime) {
        this.toastr.error('Invalid date or time!');
        return;
      }

      xml += '</reviews></reviews_dto>';

      this.reviewService.post(this.relativeUrlEditReviews, xml).subscribe(
        () => this.toastr.success('Reviews were successfully edited!'),
        err => this.toastr.error('Reviews were not successfully edited!')
      );
    }
    else {
      this.toastr.error('You did not choose a doctor or no reviews!');
    }
  }

}
