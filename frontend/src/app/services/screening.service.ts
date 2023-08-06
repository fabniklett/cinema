import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ScreeningCommandModel} from "../models/screening-command-model";
import {ScreeningListItemModel} from "../models/screening-list-item-model";
import {ScreeningListItemForReservationFormModel} from "../models/screening-list-item-for-reservation-form-model";
import {MovieSummaryDetailsModel} from "../models/movie-summary-details-model";

const BASE_URL = 'http://localhost:8080/api/screenings';
@Injectable({
  providedIn: 'root'
})
export class ScreeningService {

  constructor(private http: HttpClient) { }

  addScreening(data: ScreeningCommandModel){
    return this.http.post(BASE_URL,data);
  }

  listScreenings(): Observable<ScreeningListItemModel[]> {
    return this.http.get<ScreeningListItemModel[]>(BASE_URL);
  }

  listScreeningsForForm(): Observable<Array<ScreeningListItemForReservationFormModel>> {
    return this.http.get<Array<ScreeningListItemForReservationFormModel>>(BASE_URL + "/listForReservations");
  }

  listMoviesWithDetails(): Observable<Array<MovieSummaryDetailsModel>> {
    return this.http.get<Array<MovieSummaryDetailsModel>>(BASE_URL + '/movies');
  }
}
