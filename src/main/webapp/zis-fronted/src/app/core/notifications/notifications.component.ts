import { Component, OnInit } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {

  private relativeUrlGetNotifications: string;

  xHtmlContetntForNotifications = 'Loading notifications...'; // dobijen koriscenjem xsl transformacije

  constructor(private patientService: GenericService, private toastr: ToastrService) {
    this.relativeUrlGetNotifications = '/patient/get-notifications';
  }

  ngOnInit() {
    this.getNotifications();
  }

  getNotifications() {
    this.patientService.get<string>(this.relativeUrlGetNotifications).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
               // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
               this.xHtmlContetntForNotifications = this.patientService.replaceAllBackSlash(receivedXml.substring(1,
                receivedXml.length - 1));
              // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove
              // this.idOfNewDoctor = '';
          }
          else {
            this.xHtmlContetntForNotifications = 'Problem with loading of notifications!';
            this.toastr.error('Problem with loading of notifications!');
          }
      },
      (err) => {
        this.xHtmlContetntForNotifications = 'Problem with loading of notifications!';
        this.toastr.error('Problem with loading of notifications!');
      }
    );
  }
  
  refreshNotifications() {
	this.xHtmlContetntForNotifications = 'Loading notifications...';
	this.getNotifications();
  }
}
