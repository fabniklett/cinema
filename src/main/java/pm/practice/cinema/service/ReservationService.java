package pm.practice.cinema.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pm.practice.cinema.domain.Reservation;
import pm.practice.cinema.domain.Screening;
import pm.practice.cinema.dto.incoming.ReservationCreateDetails;
import pm.practice.cinema.dto.outgoing.MovieSummaryDetails;
import pm.practice.cinema.dto.outgoing.ReservationListItem;
import pm.practice.cinema.dto.outgoing.ScreeningListItem;
import pm.practice.cinema.repository.ReservationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository reservationRepository;
    private ScreeningService screeningService;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ScreeningService screeningService) {
        this.reservationRepository = reservationRepository;
        this.screeningService = screeningService;
    }

    public void saveReservation(ReservationCreateDetails createDetails) {
        Screening screening = screeningService.findScreeningById(createDetails.getScreeningId());
        if (screening != null) {
            Reservation reservation = new Reservation(createDetails, screening);
        reservationRepository.save(reservation); }
    }

    public List<ReservationListItem> listReservations () {
        List<ReservationListItem> reservationListItems = reservationRepository.findAll().stream()
                .map(ReservationListItem::new).collect(Collectors.toList());
        return  reservationListItems;
    }


    }





















