import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieSummaryDetailsComponent } from './movie-summary-details.component';

describe('MovieSummaryDetailsComponent', () => {
  let component: MovieSummaryDetailsComponent;
  let fixture: ComponentFixture<MovieSummaryDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MovieSummaryDetailsComponent]
    });
    fixture = TestBed.createComponent(MovieSummaryDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
