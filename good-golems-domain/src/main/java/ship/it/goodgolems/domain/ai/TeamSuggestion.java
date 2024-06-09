package ship.it.goodgolems.domain.ai;

import java.util.Set;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;

public record TeamSuggestion(
        Project project,
        Set<Employee> team
) {
}
