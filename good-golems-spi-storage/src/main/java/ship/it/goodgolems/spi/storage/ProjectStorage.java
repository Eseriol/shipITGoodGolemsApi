package ship.it.goodgolems.spi.storage;

import java.util.Set;

import ship.it.goodgolems.domain.Project;

public interface ProjectStorage {

    Set<Project> getProjects();

}
