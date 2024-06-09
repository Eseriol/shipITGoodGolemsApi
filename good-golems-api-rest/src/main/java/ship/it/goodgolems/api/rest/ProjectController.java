package ship.it.goodgolems.api.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.rest.presentation.Converter;
import ship.it.goodgolems.api.rest.presentation.ProjectDto;
import ship.it.goodgolems.core.FakeDataGeneratorServiceImpl;

/**
 * ProjectController is a REST controller that handles requests related to projects.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/projects")
public class ProjectController {

    private final FakeDataGeneratorServiceImpl fakeDataGeneratorServiceImpl;

    /**
     * Retrieves all projects from H2 database.
     *
     * @return A ResponseEntity object containing a list of ProjectDto objects.
     */
    @GetMapping()
    public ResponseEntity<List<ProjectDto>> getAllProjectsFromH2() {
        List<ProjectDto> projectDtos = fakeDataGeneratorServiceImpl.getAllProjects()
                .stream()
                .map(Converter::convert)
                .toList();
        return ResponseEntity.ok(projectDtos);
    }
}
