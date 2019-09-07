import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeDoctorReceiptComponent } from './make-doctor-receipt.component';

describe('MakeDoctorReceiptComponent', () => {
  let component: MakeDoctorReceiptComponent;
  let fixture: ComponentFixture<MakeDoctorReceiptComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeDoctorReceiptComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeDoctorReceiptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
