import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReferralsForLabComponent } from './referrals-for-lab.component';

describe('ReferralsForLabComponent', () => {
  let component: ReferralsForLabComponent;
  let fixture: ComponentFixture<ReferralsForLabComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReferralsForLabComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReferralsForLabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
