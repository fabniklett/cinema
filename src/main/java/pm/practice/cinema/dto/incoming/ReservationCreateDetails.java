package pm.practice.cinema.dto.incoming;

import lombok.Data;
import lombok.NoArgsConstructor;
import pm.practice.cinema.domain.Screening;
import pm.practice.cinema.dto.outgoing.ScreeningListItem;

@Data
@NoArgsConstructor
public class ReservationCreateDetails {

    private String name;
    private Integer numberOfSeats;
    private Long screeningId;

}
