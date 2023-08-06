package pm.practice.cinema.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pm.practice.cinema.domain.Reservation;
import pm.practice.cinema.domain.Screening;
import pm.practice.cinema.dto.incoming.ReservationCreateDetails;
import pm.practice.cinema.dto.incoming.ScreeningCommand;
import pm.practice.cinema.dto.outgoing.MovieSummaryDetails;
import pm.practice.cinema.dto.outgoing.ScreeningListItem;
import pm.practice.cinema.dto.outgoing.ScreeningListItemForReservationForm;
import pm.practice.cinema.repository.ScreeningRepository;

import java.util.*;
import java.util.stream.Collectors;

@Transactional
@Service
public class ScreeningService {


    private ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public void addScreening(ScreeningCommand screeningCommand) {
        screeningRepository.save(new Screening(screeningCommand));
    }

    public List<ScreeningListItem> listScreenings() {
        List<ScreeningListItem> screeningListItems = screeningRepository.findAll().stream()
                .map(ScreeningListItem::new).sorted(Comparator.comparing(ScreeningListItem::getScreeningDate))
                .collect(Collectors.toList());
        return screeningListItems;
    }

    public Screening findScreeningById(Long id) {
        return screeningRepository.findById(id).orElseThrow(null);
//        Optional<Screening> movieScreening = screeningRepository.findById(id);
//        return movieScreening.isPresent() ? movieScreening.get() : null;
    }

    public List<ScreeningListItemForReservationForm> listScreeningsForReservation() {
        List<ScreeningListItemForReservationForm> screeningListItems = screeningRepository.findAll().stream()
                .map(ScreeningListItemForReservationForm::new).sorted(Comparator.comparing(ScreeningListItemForReservationForm::getScreeningTime))
                .collect(Collectors.toList());
        return screeningListItems;
    }

    public List<MovieSummaryDetails> listMovieSummaries() {
        List<Screening> screenings = screeningRepository.findAll();
        Map<String, MovieSummaryDetails> summaries = new HashMap<>();
        Integer numberOfBookedSeats = 0;
        String titleOfMovie = "";
        for (Screening screening : screenings) {
            if (summaries.containsKey(screening.getTitle())) {
                MovieSummaryDetails movieSummaryDetails = summaries.get(screening.getTitle());
                movieSummaryDetails.setNumberOfScreenings(movieSummaryDetails.getNumberOfScreenings() + 1);
                for (Reservation reservation : screening.getReservations()) {
                    numberOfBookedSeats += reservation.getNumberOfSeats();
                }
                movieSummaryDetails.setTicketsSold(movieSummaryDetails.getTicketsSold() + numberOfBookedSeats);
            } else {
                MovieSummaryDetails movieSummaryDetails = new MovieSummaryDetails();
                movieSummaryDetails.setTitle(screening.getTitle());
                movieSummaryDetails.setNumberOfScreenings(1);
                int ticketsBooked = 0;
                for (Reservation reservation : screening.getReservations()) {
                    ticketsBooked += reservation.getNumberOfSeats();
                }
                movieSummaryDetails.setTicketsSold(ticketsBooked);
                summaries.put(screening.getTitle(), movieSummaryDetails);
            }
        }
        return new ArrayList<>(summaries.values());
    }
}
