import {Component, OnInit} from '@angular/core';
import {ScreeningService} from "../../services/screening.service";
import {Router} from "@angular/router";
import {ScreeningListItemModel} from "../../models/screening-list-item-model";

@Component({
  selector: 'app-screening-list',
  templateUrl: './screening-list.component.html',
  styleUrls: ['./screening-list.component.css']
})
export class ScreeningListComponent implements OnInit {

  screenings: ScreeningListItemModel[] = [];

  constructor(private screeningService: ScreeningService,
              private router: Router) {
  }

  ngOnInit() {
    this.screeningService.listScreenings().subscribe({
      next: value => { this.screenings = value },
      error: err => {}
    })
  }

  formatDate(date: Date) {
    // const options = { year: 'numeric', month: 'numeric', day: 'numeric', hour: 'numeric', minute: 'numeric', hour12: true };
    // const formatter = new Intl.DateTimeFormat('en-US',options);
    return new Date(date).toLocaleTimeString();
  }

}
