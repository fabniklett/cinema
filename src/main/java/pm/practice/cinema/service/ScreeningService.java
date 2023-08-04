package pm.practice.cinema.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pm.practice.cinema.domain.Screening;
import pm.practice.cinema.dto.incoming.ScreeningCommand;
import pm.practice.cinema.dto.outgoing.ScreeningListItem;
import pm.practice.cinema.repository.ScreeningRepository;

import java.util.Comparator;
import java.util.List;
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
}
