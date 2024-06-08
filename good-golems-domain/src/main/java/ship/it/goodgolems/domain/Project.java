package ship.it.goodgolems.domain;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.util.Assert;

public record Project(
        String name,
        Set<Employee> employees,
        Set<ProjectRequirement> requirements
) {

    public Project{
        Assert.hasText(name, "Name of project must not be empty");
        employees = Optional.ofNullable(employees).orElse(new HashSet<>());
        requirements = Optional.ofNullable(requirements).orElse(new HashSet<>());
    }
}
