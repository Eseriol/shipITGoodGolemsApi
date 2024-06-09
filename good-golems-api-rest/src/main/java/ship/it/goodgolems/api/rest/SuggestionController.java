package ship.it.goodgolems.api.rest;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.AiSuggestionApi;
import ship.it.goodgolems.api.rest.presentation.Converter;
import ship.it.goodgolems.api.rest.presentation.TeamSuggestionDto;

/**
 * The SuggestionController class is responsible for handling HTTP requests related to suggesting teams for projects.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/suggest", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class SuggestionController {

    private final AiSuggestionApi suggestionApi;

    /**
     * Retrieves the suggested team for a project.
     *
     * @param projectId The ID of the project for which employees need to be suggested.
     * @return A ResponseEntity that contains the suggested team as a TeamSuggestionDto object.
     */
    @GetMapping("/team-for-project/{projectId}")
    public ResponseEntity<TeamSuggestionDto> getResponse(@PathVariable Long projectId) {
        var dtoBuilder = TeamSuggestionDto.builder();
        var suggestion = suggestionApi.suggestEmployees(projectId);
        var comment = suggestionApi.explainSuggestion(suggestion.project(), suggestion.team());
        dtoBuilder.projectName(suggestion.project()
                        .name())
                .explanation(comment)
                .project(Converter.convert(suggestion.project()))
                .team(suggestion.team()
                        .stream()
                        .map(Converter::convert)
                        .collect(Collectors.toSet()));
        return ResponseEntity.ofNullable(dtoBuilder.build());
    }
}
