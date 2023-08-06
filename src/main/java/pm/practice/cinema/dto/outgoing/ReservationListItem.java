package pm.practice.cinema.dto.outgoing;

import lombok.Data;
import lombok.NoArgsConstructor;
import pm.practice.cinema.domain.Reservation;

import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class ReservationListItem {

    private String name;
    private String title;
    private Integer numberOfSeats;
    private String timeOfScreening;


    public ReservationListItem(Reservation reservation) {
        this.name = reservation.getName();
        this.title = reservation.getScreening().getTitle();
        this.numberOfSeats = reservation.getNumberOfSeats();
        this.timeOfScreening = reservation.getScreening().getScreeningDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
    }
}
