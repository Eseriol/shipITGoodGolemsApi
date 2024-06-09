package ship.it.goodgolems.jpa.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import ship.it.goodgolems.jpa.model.ProjectEntity;

@Repository
public interface ProjectRepository extends ListCrudRepository<ProjectEntity, Long> {
}
