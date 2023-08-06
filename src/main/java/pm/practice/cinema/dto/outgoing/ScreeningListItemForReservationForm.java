package pm.practice.cinema.dto.outgoing;

import lombok.Data;
import pm.practice.cinema.domain.Screening;

import java.time.format.DateTimeFormatter;

@Data
public class ScreeningListItemForReservationForm {

    private Long id;
    private String title;
    private String screeningTime;

    public ScreeningListItemForReservationForm(Screening screening) {
    this.id = screening.getId();
    this.title = screening.getTitle();
    this.screeningTime = screening.getScreeningDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
    }










}
