import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ReservationCreateDetails} from "../models/reservation-create-details";
import {ReservationListItemModel} from "../models/reservation-list-item-model";
import {Observable} from "rxjs";
import {ScreeningListItemForReservationFormModel} from "../models/screening-list-item-for-reservation-form-model";

const BASE_URL = 'http://localhost:8080/api/reservations';
@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) { }

  addReservation(data: ReservationCreateDetails) {
    return this.http.post(BASE_URL,data);
  }

  listReservations(): Observable<Array<ReservationListItemModel>> {
    return this.http.get<Array<ReservationListItemModel>>(BASE_URL);
  }
}
