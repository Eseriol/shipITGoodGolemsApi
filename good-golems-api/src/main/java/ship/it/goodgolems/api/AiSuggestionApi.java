package ship.it.goodgolems.api;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;

public interface AiSuggestionApi {

    /**
     * Returns a map of suggested employees for each project.
     *
     * @param projects A collection of projects for which employees need to be suggested.
     * @return A map where each project is mapped to a set of suggested employees.
     */
    Map<Project, Set<Employee>> suggestEmployees(final Collection<Project> projects);

    /**
     * Suggests projects for a given employee.
     *
     * @param employee The employee for whom projects need to be suggested.
     * @return A set of projects that are suggested for the given employee.
     */
    Set<Project> suggestProjects(final Employee employee);

}
