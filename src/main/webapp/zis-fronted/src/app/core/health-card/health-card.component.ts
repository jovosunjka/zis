import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-health-card',
  templateUrl: './health-card.component.html',
  styleUrls: ['./health-card.component.css']
})
export class HealthCardComponent implements OnInit {
  @Input()
  xHtmlContetntForSelectedDoctor: string; // dobijen koriscenjem xsl transformacije

  constructor() { }

  ngOnInit() {
  }

}
