package ship.it.goodgolems.api.rest.presentation;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EmployeeDto(
        @JsonProperty("fullname")
        String fullName,

        @JsonProperty("position")
        String position,

        @JsonProperty("experience")
        Set<ExperienceDto> experience,

        @JsonIgnore
        ProjectDto currentProject
) {

    public EmployeeDto {
        Assert.hasText(fullName, "Name of employee must not be empty");
        fullName = Optional.ofNullable(fullName).orElse("");
        position = Optional.ofNullable(position)
                .orElse("");
        experience = Optional.ofNullable(experience).orElse(Set.of());
    }

    @JsonProperty("available")
    public boolean isAvailable() {
        return Objects.isNull(currentProject);
    }

    public boolean experiencedIn(StackDto stack, int minYears) {
        return experience.stream()
                .filter(exp -> exp.stack()
                        .equals(stack))
                .anyMatch(exp -> exp.years() >= minYears);
    }
}
