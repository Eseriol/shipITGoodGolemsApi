package ship.it.goodgolems.api.rest.presentation;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

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
