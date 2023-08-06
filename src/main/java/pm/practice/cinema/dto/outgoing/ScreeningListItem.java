package pm.practice.cinema.dto.outgoing;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pm.practice.cinema.domain.Reservation;
import pm.practice.cinema.domain.Screening;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class ScreeningListItem {

    private String pictureUrl;
    private String title;
    private LocalDateTime screeningDate;
    private Integer totalSeats;
    private Integer freeSeats;

    public ScreeningListItem(Screening screening) {
        this.pictureUrl = screening.getPictureUrl();
        this.title = screening.getTitle();
        this.screeningDate = screening.getScreeningDate();
        this.totalSeats = screening.getTotalSeat();
        this.freeSeats = this.totalSeats - screening.getReservations().stream().map(Reservation::getNumberOfSeats).mapToInt(i -> i).sum();
    }

}
