package pm.practice.cinema.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pm.practice.cinema.dto.incoming.ScreeningCommand;
import pm.practice.cinema.dto.outgoing.ScreeningListItem;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "screening_id")
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private LocalDateTime screeningDate;
    @Column(nullable = false)
    private Integer totalSeat;
    @Column
    private String pictureUrl;

    @OneToMany(mappedBy = "screening")
    private List<Reservation> reservations;

    public Screening(ScreeningCommand screeningCommand) {
        this.title = screeningCommand.getTitle();
        this.screeningDate = screeningCommand.getScreeningDate();
        this.totalSeat = screeningCommand.getTotalSeat();
        this.pictureUrl = screeningCommand.getPictureUrl();
    }

    public Screening(ScreeningListItem screeningListItem) {
        this.title = screeningListItem.getTitle();
        this.screeningDate = screeningListItem.getScreeningDate();
        this.totalSeat = screeningListItem.getTotalSeats();
        this.pictureUrl = screeningListItem.getPictureUrl();
    }

    public Screening(Long id) {
        this.id = id;
    }
}
