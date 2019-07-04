import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditHealthCardComponent } from './edit-health-card.component';

describe('EditHealthCardComponent', () => {
  let component: EditHealthCardComponent;
  let fixture: ComponentFixture<EditHealthCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditHealthCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditHealthCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
