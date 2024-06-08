package ship.it.goodgolems.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.VectorApi;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class VectorController {

    private final VectorApi vectorApi;

    @GetMapping("/gen")
    public String genVectorSearch(@RequestParam String query) {
        return vectorApi.genVectorSearch(query);
    }
}