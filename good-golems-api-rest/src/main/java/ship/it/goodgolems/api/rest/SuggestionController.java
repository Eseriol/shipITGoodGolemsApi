package ship.it.goodgolems.api.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.AiSuggestionApi;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class SuggestionController {

    private final AiSuggestionApi suggestionApi;


}
