import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeReferralForSpecExamComponent } from './make-referral-for-spec-exam.component';

describe('MakeReferralForSpecExamComponent', () => {
  let component: MakeReferralForSpecExamComponent;
  let fixture: ComponentFixture<MakeReferralForSpecExamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeReferralForSpecExamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeReferralForSpecExamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
