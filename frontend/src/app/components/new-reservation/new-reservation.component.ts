import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ReservationService} from "../../services/reservation.service";
import {ScreeningListItemModel} from "../../models/screening-list-item-model";
import {ScreeningService} from "../../services/screening.service";
import {ScreeningCommandModel} from "../../models/screening-command-model";
import {Router} from "@angular/router";
import {ScreeningListItemForReservationFormModel} from "../../models/screening-list-item-for-reservation-form-model";
import {validationHandler} from "../../utils/validation-handler";

@Component({
  selector: 'app-new-reservation',
  templateUrl: './new-reservation.component.html',
  styleUrls: ['./new-reservation.component.css']
})
export class NewReservationComponent implements OnInit {

  reservationForm: FormGroup;
  screenings!: ScreeningListItemForReservationFormModel[];

  constructor(private reservationService: ReservationService,
              private formBuilder: FormBuilder,
              private screenService: ScreeningService,
              private router: Router) {
    this.reservationForm = formBuilder.group({
      name: ['', Validators.required],
      numberOfSeats: ['', Validators.required],
      screeningId: ['', Validators.required]
    })
  }

  ngOnInit() {
    this.screenService.listScreeningsForForm().subscribe({
      next:
        (screeningList: ScreeningListItemForReservationFormModel[]) => {
          this.screenings = screeningList
        },
      error: err => {
        validationHandler(err, this.reservationForm)
      },
      complete: () => {
        this.reservationForm.reset()
      }

    })
  }

  onSubmit() {
    const data = this.reservationForm.value;
    this.reservationService.addReservation(data).subscribe({
      next: value => {
        console.log("Success")
      },
      error: err => {
        validationHandler(err, this.reservationForm)
      },
      complete: () => {
        this.reservationForm.reset()
      }
    })


  }
}



