import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ScreeningFormComponent } from './components/screening-form/screening-form.component';
import {HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import { ScreeningListComponent } from './components/screening-list/screening-list.component';
import { NewReservationComponent } from './components/new-reservation/new-reservation.component';
import { ReservationListComponent } from './components/reservation-list/reservation-list.component';
import { MovieSummaryDetailsComponent } from './components/movie-summary-details/movie-summary-details.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ScreeningFormComponent,
    ScreeningListComponent,
    NewReservationComponent,
    ReservationListComponent,
    MovieSummaryDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
