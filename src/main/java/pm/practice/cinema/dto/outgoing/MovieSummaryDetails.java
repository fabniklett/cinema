package pm.practice.cinema.dto.outgoing;

import lombok.Data;
import lombok.NoArgsConstructor;
import pm.practice.cinema.domain.Reservation;
import pm.practice.cinema.domain.Screening;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class MovieSummaryDetails {

    private String title;
    private Integer numberOfScreenings;
    private Integer ticketsSold;


}
