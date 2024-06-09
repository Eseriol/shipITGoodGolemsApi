package ship.it.goodgolems.api.rest.presentation;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ProjectDto(
        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("employees")
        Set<EmployeeDto> employees,
        @JsonProperty("requirements")
        Set<ProjectRequirementDto> requirements
) {

    public ProjectDto {
        Assert.hasText(name, "Name of project must not be empty");
        employees = Optional.ofNullable(employees).orElse(new HashSet<>());
        requirements = Optional.ofNullable(requirements).orElse(new HashSet<>());
    }
}
