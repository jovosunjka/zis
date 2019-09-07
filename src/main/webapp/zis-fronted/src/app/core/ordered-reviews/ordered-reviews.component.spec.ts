import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderedReviewsComponent } from './ordered-reviews.component';

describe('OrderedReviewsComponent', () => {
  let component: OrderedReviewsComponent;
  let fixture: ComponentFixture<OrderedReviewsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderedReviewsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderedReviewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
