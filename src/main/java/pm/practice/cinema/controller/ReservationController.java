package pm.practice.cinema.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pm.practice.cinema.dto.incoming.ReservationCreateDetails;
import pm.practice.cinema.dto.outgoing.ReservationListItem;
import pm.practice.cinema.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private ReservationService reservationService;

    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping
    public ResponseEntity addReservation (@RequestBody @Valid ReservationCreateDetails createDetails) {
        reservationService.saveReservation(createDetails);
        logger.info("Ticket(s) reserved");
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReservationListItem>> listReservations () {
        List<ReservationListItem> listOfReservations = reservationService.listReservations();
        logger.info("Reservations page requested");
        return new ResponseEntity<>(listOfReservations,HttpStatus.OK);
    }
}
