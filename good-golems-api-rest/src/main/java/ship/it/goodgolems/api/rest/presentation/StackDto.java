package ship.it.goodgolems.api.rest.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ProjectDto represents the Data Transfer Object for a project.
 * It is used to transfer data between different layers of an application.
 */
public record StackDto(
        @JsonProperty("technologyName")
        String technologyName
) {

}
