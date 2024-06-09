package ship.it.goodgolems.api.rest.presentation;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;

/**
 * TeamSuggestionDto represents the Data Transfer Object for a team suggestion.
 * It is used to transfer data between different layers of an application.
 */
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TeamSuggestionDto(
        String projectName,
        String explanation,
        ProjectDto project,
        Set<EmployeeDto> team
) {
}
