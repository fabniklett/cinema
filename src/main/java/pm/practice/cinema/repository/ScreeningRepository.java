package pm.practice.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pm.practice.cinema.domain.Screening;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}
