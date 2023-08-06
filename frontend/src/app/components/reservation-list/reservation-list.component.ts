import {Component, OnInit} from '@angular/core';
import {ReservationListItemModel} from "../../models/reservation-list-item-model";
import {ReservationService} from "../../services/reservation.service";
import {Router} from "@angular/router";
import {validationHandler} from "../../utils/validation-handler";

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit{

  reservations: ReservationListItemModel[] = [];

  constructor(private reservationService: ReservationService,
              private router: Router) {
  }

  ngOnInit() {
    this.reservationService.listReservations().subscribe({
      next: value => {this.reservations = value },
      error: err => {}
    })
  }


}
