package ship.it.goodgolems.domain;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public record Employee(
        String fullName,
        String position,
        Set<Experience> experience,
        Project currentProject
) {

    public Employee {
        fullName = Optional.ofNullable(fullName).orElse("");
        position = Optional.ofNullable(position)
                .orElse("");
        experience = Optional.ofNullable(experience).orElse(Set.of());
    }

    public boolean isAvailable() {
        return Objects.isNull(currentProject);
    }

    public boolean experiencedIn(Stack stack, int minYears) {
        return experience.stream()
                .filter(exp -> exp.stack()
                        .equals(stack))
                .anyMatch(exp -> exp.years() >= minYears);
    }
}
