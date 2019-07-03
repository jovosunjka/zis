import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReferralsForSpecExaminationComponent } from './referrals-for-spec-examination.component';

describe('ReferralsForSpecExaminationComponent', () => {
  let component: ReferralsForSpecExaminationComponent;
  let fixture: ComponentFixture<ReferralsForSpecExaminationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReferralsForSpecExaminationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReferralsForSpecExaminationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
