package ship.it.goodgolems.domain;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The ProjectRequirement class represents the requirements of a project.
 * It includes information about the required technology stack and the number of employees with specific years of experience in the stack.
 */
public record ProjectRequirement(
        Stack stack,
        Set<ExperiencedCount> experiencedCount
) {

    public ProjectRequirement {
        stack = Optional.ofNullable(stack).orElse(new Stack(""));
        experiencedCount = Optional.ofNullable(experiencedCount)
                .orElse(Set.of())
                .stream()
                .filter(e -> e.countOfEmployee() > 0)
                .collect(Collectors.toSet());
    }

}
