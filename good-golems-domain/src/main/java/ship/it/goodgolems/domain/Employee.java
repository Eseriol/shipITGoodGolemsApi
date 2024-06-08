package ship.it.goodgolems.domain;

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
}
