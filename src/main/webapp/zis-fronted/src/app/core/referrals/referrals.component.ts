import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-referrals',
  templateUrl: './referrals.component.html',
  styleUrls: ['./referrals.component.css']
})
export class ReferralsComponent implements OnInit {

  @Input()
  idOfPatientNum: string;

  constructor() { }

  ngOnInit() {
  }

}
