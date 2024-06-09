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

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/suggest", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class SuggestionController {

    private final AiSuggestionApi suggestionApi;

    @GetMapping("/team-for-project/{projectId}")
    public ResponseEntity<TeamSuggestionDto> getResponse(@PathVariable Long projectId) {
        var dtoBuilder = TeamSuggestionDto.builder();
        var suggestion = suggestionApi.suggestEmployees(projectId);
        dtoBuilder.projectName(suggestion.project()
                        .name())
                .explanation("Here is a suggested team for the project")
                .project(Converter.convert(suggestion.project()))
                .team(suggestion.team()
                        .stream()
                        .map(Converter::convert)
                        .collect(Collectors.toSet()));
        return ResponseEntity.ofNullable(dtoBuilder.build());
    }
}
