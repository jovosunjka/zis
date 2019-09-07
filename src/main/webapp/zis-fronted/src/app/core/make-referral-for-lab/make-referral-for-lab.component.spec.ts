import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeReferralForLabComponent } from './make-referral-for-lab.component';

describe('MakeReferralForLabComponent', () => {
  let component: MakeReferralForLabComponent;
  let fixture: ComponentFixture<MakeReferralForLabComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeReferralForLabComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeReferralForLabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
