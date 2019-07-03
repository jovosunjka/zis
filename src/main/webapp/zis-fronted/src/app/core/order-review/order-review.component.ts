import { Component, OnInit } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';

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
  idOfReview: string;

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
              this.xHtmlContetntForOrderedReviews = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
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
              this.xHtmlContetntForFreeReviews = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
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
    if (this.idOfReview && this.idOfReview !== '') {
      this.reviewService.putById(this.relativeUrlOrderReview, this.idOfReview).subscribe(
        () => {
          this.idOfReview = '';
          this.getOrderedReviews();
          this.getFreeReviews();
          this.toastr.success('You have successfully order a review!');
        },
        (err) => this.toastr.error('You failed to order a review!')
      );
    }
    else {
      this.toastr.error('You did not enter the id of the review!');
    }
  }

}
