package ship.it.goodgolems.spi.ai.model;

import java.util.Collection;
import java.util.List;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;

/**
 * The EmployeeSuggester interface represents a class that suggests employees for a project.
 */
public interface EmployeeSuggester {

    List<Employee> sagestEmployeesForProject(final Project project);

    List<Employee> sagestEmployeesForProject(final Project project, final Collection<Employee> employees);

}
