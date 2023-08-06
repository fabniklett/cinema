package pm.practice.cinema.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pm.practice.cinema.dto.incoming.ReservationCreateDetails;
import pm.practice.cinema.dto.incoming.ScreeningCommand;
import pm.practice.cinema.dto.outgoing.MovieSummaryDetails;
import pm.practice.cinema.dto.outgoing.ScreeningListItem;
import pm.practice.cinema.dto.outgoing.ScreeningListItemForReservationForm;
import pm.practice.cinema.service.ScreeningService;

import java.util.List;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {

    private ScreeningService screeningService;
    private static final Logger logger = LoggerFactory.getLogger(ScreeningController.class);

    @Autowired
    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @PostMapping
    public ResponseEntity addScreening (@RequestBody ScreeningCommand screeningCommand) {
        screeningService.addScreening(screeningCommand);
        logger.info("The screening has been successfully added");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScreeningListItem>> listScreenings () {
        List<ScreeningListItem> listOfScreenings = screeningService.listScreenings();
        logger.info("Screenings page requested");
        return new ResponseEntity<>(listOfScreenings, HttpStatus.OK);
    }

    @GetMapping("/listForReservations")
    public ResponseEntity<List<ScreeningListItemForReservationForm>> listScreeningsForReservationForm () {
        List<ScreeningListItemForReservationForm> listOfScreenings = screeningService.listScreeningsForReservation();
        logger.info("Screenings page requested");
        return new ResponseEntity<>(listOfScreenings, HttpStatus.OK);
    }


    @GetMapping("/movies")
    public ResponseEntity<List<MovieSummaryDetails>> listMoviesWithDetails () {
        List<MovieSummaryDetails> summaryDetails = screeningService.listMovieSummaries();
        logger.info("Movie summary page requested");
        return new ResponseEntity<>(summaryDetails,HttpStatus.OK);
    }

}
