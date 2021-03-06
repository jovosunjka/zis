import { Component, OnInit } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';

declare const $: any;

@Component({
  selector: 'app-order-review',
  templateUrl: './order-review.component.html',
  styleUrls: ['./order-review.component.css']
})
export class OrderReviewComponent implements OnInit {
  xHtmlContetntForFreeReviews: string; // dobijen koriscenjem xsl transformacije
  xHtmlContetntForOrderedReviews: string; // dobijen koriscenjem xsl transformacije
  relativeUrlFreeReviews: string;
  relativeUrlOrderedReviews: string;
  relativeUrlOrderReview: string;

  constructor(private reviewService: GenericService, private toastr: ToastrService) {
    this.xHtmlContetntForFreeReviews = 'Loading free reviews...';
    this.xHtmlContetntForOrderedReviews = 'Loading ordered reviews...';
    this.relativeUrlFreeReviews = '/patient/free-reviews';
    this.relativeUrlOrderedReviews = '/patient/ordered-reviews';
    this.relativeUrlOrderReview = '/patient/order-review?id-of-review=';
  }

  ngOnInit() {
    this.getOrderedReviews();
    this.getFreeReviews();
  }

  getOrderedReviews() {
    this.reviewService.get<string>(this.relativeUrlOrderedReviews).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
              // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
              this.xHtmlContetntForOrderedReviews = this.reviewService.replaceAllBackSlash(receivedXml.substring(1,
                receivedXml.length - 1));
              // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove
              this.toastr.success('Ordered reviews are successfully loaded!');
          }
          else {
            this.xHtmlContetntForOrderedReviews = 'Problem with loading of ordered reviews!';
            this.toastr.error('Problem with loading of ordered reviews!');
          }
      },
      (err) => {
        this.xHtmlContetntForOrderedReviews = 'Problem with loading of ordered reviews!';
        this.toastr.error('Problem with loading of ordered reviews!');
      }
    );
  }

  getFreeReviews() {
    this.reviewService.get<string>(this.relativeUrlFreeReviews).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
               // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
               this.xHtmlContetntForFreeReviews = this.reviewService.replaceAllBackSlash(receivedXml.substring(1,
                receivedXml.length - 1));
              // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove
              this.toastr.success('Free reviews are successfully loaded!');
          }
          else {
            this.xHtmlContetntForFreeReviews = 'Problem with loading of free reviews!';
            this.toastr.error('Problem with loading of free reviews!');
          }
      },
      (err) => {
        this.xHtmlContetntForFreeReviews = 'Problem with loading of free reviews!';
        this.toastr.error('Problem with loading of free reviews!');
      }
    );
  }

  orderReview() {
	const idOfReview = $('#id_select_review').val();
    if (idOfReview && idOfReview !== '') {
      this.reviewService.putById(this.relativeUrlOrderReview, idOfReview).subscribe(
        () => {
          // this.idOfReview = '';
          this.getOrderedReviews();
          this.getFreeReviews();
          this.toastr.success('You have successfully order a review!');
        },
        (err) => this.toastr.error('You failed to order a review!')
      );
    }
    else {
      this.toastr.error('You did not choose a review!');
    }
  }

}
