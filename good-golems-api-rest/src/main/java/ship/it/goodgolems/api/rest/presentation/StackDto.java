package ship.it.goodgolems.api.rest.presentation;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StackDto(
        @JsonProperty("technologyName")
        String technologyName
) {
    public StackDto {
        Assert.hasText(technologyName, "Name of technology must not be empty");
    }
}
