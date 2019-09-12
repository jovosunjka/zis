import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportCreatedComponent } from './report-created.component';

describe('ReportCreatedComponent', () => {
  let component: ReportCreatedComponent;
  let fixture: ComponentFixture<ReportCreatedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportCreatedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportCreatedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
