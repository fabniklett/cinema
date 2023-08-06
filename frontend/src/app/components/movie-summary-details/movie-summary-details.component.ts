import {Component, OnInit} from '@angular/core';
import {MovieSummaryDetailsModel} from "../../models/movie-summary-details-model";
import {ScreeningService} from "../../services/screening.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-movie-summary-details',
  templateUrl: './movie-summary-details.component.html',
  styleUrls: ['./movie-summary-details.component.css']
})
export class MovieSummaryDetailsComponent implements OnInit{

  movies: MovieSummaryDetailsModel[] = [];

  constructor(private movieService: ScreeningService,
              private router: Router) {
  }

  ngOnInit() {
    this.movieService.listMoviesWithDetails().subscribe({
      next: values => {this.movies = values},
      error: err => {}
    })
  }


}
