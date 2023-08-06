import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ScreeningFormComponent} from "./components/screening-form/screening-form.component";
import {ScreeningListComponent} from "./components/screening-list/screening-list.component";
import {NewReservationComponent} from "./components/new-reservation/new-reservation.component";
import {ReservationListComponent} from "./components/reservation-list/reservation-list.component";
import {MovieSummaryDetailsComponent} from "./components/movie-summary-details/movie-summary-details.component";

const routes: Routes = [
  {path:'screening-form', component: ScreeningFormComponent},
  {path:'screening-list', component: ScreeningListComponent},
  {path:'new-reservation', component: NewReservationComponent},
  {path: 'reservation-list', component: ReservationListComponent},
  {path: 'movie-summary-details',component: MovieSummaryDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
