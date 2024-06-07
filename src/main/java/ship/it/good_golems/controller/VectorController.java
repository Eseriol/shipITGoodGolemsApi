package ship.it.good_golems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ship.it.good_golems.service.ChromeVectorService;

@RestController
@RequestMapping("api/v1")
public class VectorController {

    @Autowired
    ChromeVectorService vectorServices;

    @GetMapping("/gen")
    public String genVectorSearch(@RequestParam String query) {
        return vectorServices.simpleVector(query).get(0).getContent().toString();
    }
}