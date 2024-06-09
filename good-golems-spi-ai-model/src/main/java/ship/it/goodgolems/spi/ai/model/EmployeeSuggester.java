package ship.it.goodgolems.spi.ai.model;

import java.util.Collection;
import java.util.List;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;

public interface EmployeeSuggester {

    List<Employee> sagestEmployeesForProject(final Project project);

    List<Employee> sagestEmployeesForProject(final Project project, final Collection<Employee> employees);

}
