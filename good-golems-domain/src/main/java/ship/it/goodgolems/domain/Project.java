package ship.it.goodgolems.domain;

import java.util.Set;

public record Project(
        String name,
        Set<Employee> employees,
        ProjectRequirement requirements
) {
}
