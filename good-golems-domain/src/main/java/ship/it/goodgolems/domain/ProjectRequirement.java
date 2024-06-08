package ship.it.goodgolems.domain;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
