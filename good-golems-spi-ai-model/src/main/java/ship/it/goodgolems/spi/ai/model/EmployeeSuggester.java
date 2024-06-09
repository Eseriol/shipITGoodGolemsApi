package ship.it.goodgolems.spi.ai.model;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;

public interface EmployeeSuggester {

    Optional<Set<Employee>> sagestEmployeesForProject(final Project project);

    Optional<Set<Employee>> sagestEmployeesForProject(final Project project, final Collection<Employee> employees);

}
