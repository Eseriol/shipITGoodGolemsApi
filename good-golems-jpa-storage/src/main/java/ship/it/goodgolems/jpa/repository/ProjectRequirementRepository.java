package ship.it.goodgolems.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import ship.it.goodgolems.domain.ProjectRequirement;

public interface ProjectRequirementRepository extends CrudRepository<ProjectRequirement, Long> {
}
