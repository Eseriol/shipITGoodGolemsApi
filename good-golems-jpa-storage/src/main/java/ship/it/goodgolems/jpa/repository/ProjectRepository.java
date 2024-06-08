package ship.it.goodgolems.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ship.it.goodgolems.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
