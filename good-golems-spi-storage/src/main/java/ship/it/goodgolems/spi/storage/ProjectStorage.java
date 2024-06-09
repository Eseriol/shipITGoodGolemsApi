package ship.it.goodgolems.spi.storage;

import java.util.Optional;
import java.util.Set;

import ship.it.goodgolems.domain.Project;

public interface ProjectStorage {

    /**
     * Get all projects from DB
     * @return
     */
    Set<Project> getProjects();

    Optional<Project> getProjectById(Long id);

}
