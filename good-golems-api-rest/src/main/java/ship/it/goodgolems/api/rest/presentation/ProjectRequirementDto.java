package ship.it.goodgolems.api.rest.presentation;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ProjectRequirementDto represents the Data Transfer Object for project requirement information.
 * It is used to transfer data between different layers of an application.
 */
public record ProjectRequirementDto(
        @JsonProperty("stack")
        StackDto stack,
        @JsonProperty("experiencedCount")
        Set<ExperiencedCountDto> experiencedCount
) {

    public ProjectRequirementDto {
        stack = Optional.ofNullable(stack).orElse(new StackDto(""));
        experiencedCount = Optional.ofNullable(experiencedCount)
                .orElse(Set.of())
                .stream()
                .filter(e -> e.countOfEmployee() > 0)
                .collect(Collectors.toSet());
    }

}
