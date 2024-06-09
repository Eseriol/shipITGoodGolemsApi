package ship.it.goodgolems.spi.storage;

import java.util.Optional;
import java.util.Set;

import ship.it.goodgolems.domain.Project;

/**
 * The ProjectStorage interface provides methods for retrieving projects from a database.
 */
public interface ProjectStorage {

    /**
     * Get all projects from DB
     * @return
     */
    Set<Project> getProjects();

    Optional<Project> getProjectById(Long id);

}
