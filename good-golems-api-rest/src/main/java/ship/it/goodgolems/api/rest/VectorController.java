package ship.it.goodgolems.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.VectorApi;

/**
 * The VectorController class is a REST controller that handles vector search requests.
 * It provides an endpoint to generate vector-based search queries.
 *
 * Example usage:
 *
 * VectorController vectorController = new VectorController(vectorApi);
 * String result = vectorController.genVectorSearch("example query");
 *
 * Note: The VectorApi interface must be implemented and injected into the VectorController constructor.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class VectorController {

    private final VectorApi vectorApi;

    /**
     * Generates a vector-based search query using the specified query string.
     *
     * @param query the query string to be used for generating the search query
     * @return the generated vector-based search query
     */
    @GetMapping("/gen")
    public String genVectorSearch(@RequestParam String query) {
        return vectorApi.genVectorSearch(query);
    }
}