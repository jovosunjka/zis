import { Component, OnInit } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-ordered-reviews',
  templateUrl: './ordered-reviews.component.html',
  styleUrls: ['./ordered-reviews.component.css']
})
export class OrderedReviewsComponent implements OnInit {
  xHtmlContetntForOrderedReviews: string; // dobijen koriscenjem xsl transformacije
  relativeUrlOrderedReviews: string;


  constructor(private doctorService: GenericService, private toastr: ToastrService) {
    this.relativeUrlOrderedReviews = '/doctor/ordered-reviews';
    this.xHtmlContetntForOrderedReviews = 'Loading ordered reviews...';
   }

  ngOnInit() {
    this.getOrderedReviews();
  }

  getOrderedReviews () {
    this.doctorService.get<string>(this.relativeUrlOrderedReviews).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
             // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
             this.xHtmlContetntForOrderedReviews = this.doctorService.replaceAllBackSlash(receivedXml.substring(1,
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
}
