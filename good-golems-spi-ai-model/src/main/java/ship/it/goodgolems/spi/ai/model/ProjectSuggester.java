package ship.it.goodgolems.spi.ai.model;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;

public interface ProjectSuggester {

    Optional<Set<Project>> findProjectsForEmployee(final Employee employee);

    Optional<Set<Project>> findProjectsForEmployee(final Employee employee, final Collection<Project> projects);

}
