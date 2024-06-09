package ship.it.goodgolems.api.rest.presentation;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ExperienceDto represents the Data Transfer Object for the experience of an employee.
 * It is used to transfer data between different layers of an application.
 */
public record ExperienceDto(
        @JsonProperty("stack")
        StackDto stack,
        @JsonProperty("years")
        int years
) {

    public ExperienceDto {
        stack = Optional.ofNullable(stack).orElse(new StackDto(""));
        years = years < 0 ? 0 : years;
    }
}
