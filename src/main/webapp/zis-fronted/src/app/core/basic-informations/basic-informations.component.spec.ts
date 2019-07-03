import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BasicInformationsComponent } from './basic-informations.component';

describe('BasicInformationsComponent', () => {
  let component: BasicInformationsComponent;
  let fixture: ComponentFixture<BasicInformationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BasicInformationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BasicInformationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
