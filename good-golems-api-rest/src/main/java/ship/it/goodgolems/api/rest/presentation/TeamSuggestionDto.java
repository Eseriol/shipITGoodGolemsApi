package ship.it.goodgolems.api.rest.presentation;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TeamSuggestionDto(
        String projectName,
        String explanation,
        ProjectDto project,
        Set<EmployeeDto> team
) {
}
