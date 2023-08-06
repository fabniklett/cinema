import {ScreeningCommandModel} from "./screening-command-model";
import {ScreeningListItemModel} from "./screening-list-item-model";

export interface ReservationCreateDetails{
  name: string;
  numberOfSeats: number;
  screeningId: number;
}
