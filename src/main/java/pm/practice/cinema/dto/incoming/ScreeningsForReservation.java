package pm.practice.cinema.dto.incoming;

import lombok.Data;
import lombok.NoArgsConstructor;
import pm.practice.cinema.dto.outgoing.ScreeningListItem;

import java.util.List;

@Data
@NoArgsConstructor
public class ScreeningsForReservation {

    private List<ScreeningListItem> screeningsForReservation;
}
