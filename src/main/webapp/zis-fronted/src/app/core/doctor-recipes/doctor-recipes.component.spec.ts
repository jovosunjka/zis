import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorRecipesComponent } from './doctor-recipes.component';

describe('DoctorRecipesComponent', () => {
  let component: DoctorRecipesComponent;
  let fixture: ComponentFixture<DoctorRecipesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DoctorRecipesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorRecipesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
