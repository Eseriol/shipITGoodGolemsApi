package ship.it.goodgolems.domain.ai;

import java.util.Set;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;

/**
 * The TeamSuggestion class represents a suggestion of employees for a specific project.
 */
public record TeamSuggestion(
        Project project,
        Set<Employee> team
) {
}
