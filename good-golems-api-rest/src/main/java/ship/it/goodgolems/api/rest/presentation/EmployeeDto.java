package ship.it.goodgolems.api.rest.presentation;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EmployeeDto(
        @JsonProperty("id")
        Integer id,

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

}
