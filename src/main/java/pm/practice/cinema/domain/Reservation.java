package pm.practice.cinema.domain;

import jakarta.persistence.*;
import lombok.Data;
import pm.practice.cinema.dto.incoming.ReservationCreateDetails;
import pm.practice.cinema.dto.outgoing.ScreeningListItem;

import java.time.LocalDateTime;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer numberOfSeats;
    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screening;


    public Reservation(ReservationCreateDetails createDetails, Screening screening) {
        this.name = createDetails.getName();
        this.numberOfSeats = createDetails.getNumberOfSeats();
        this.screening = screening;
    }




    public Reservation() {

    }


}
