package ship.it.goodgolems.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import ship.it.goodgolems.domain.Experience;

public interface ExperienceRepository extends CrudRepository<Experience, Long> {
}
