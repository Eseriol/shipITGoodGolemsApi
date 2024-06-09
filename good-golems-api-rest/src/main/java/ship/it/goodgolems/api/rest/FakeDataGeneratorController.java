package ship.it.goodgolems.api.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.FakeDataGeneratorApi;
import ship.it.goodgolems.api.rest.presentation.Converter;
import ship.it.goodgolems.api.rest.presentation.EmployeeDto;
import ship.it.goodgolems.api.rest.presentation.ProjectDto;


/**
 * FakeDataGeneratorController is a REST controller that handles requests for generating fake data.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/faker")
public class FakeDataGeneratorController {

    private final FakeDataGeneratorApi fakeDataGeneratorApi;


    /**
     * Generates fake employees data based on the specified generation target.
     *
     * @param generationTarget the number of employees to generate
     * @return the ResponseEntity containing a list of EmployeeDto objects
     */
    @PostMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> fakeEmployeesDataGen(@RequestParam int generationTarget) {

        List<EmployeeDto> employeeDtos = fakeDataGeneratorApi.generateEmployees(generationTarget).stream()
                .map(Converter::convert)
                .toList();
        return ResponseEntity.ok(employeeDtos);
    }

    /**
     * Generates fake project data based on the specified generation target.
     *
     * @param generationTarget the number of projects to generate
     * @return the ResponseEntity containing a list of ProjectDto objects
     */
    @PostMapping("/project")
    public ResponseEntity<List<ProjectDto>> fakeProjectDataGen(@RequestParam int generationTarget) {
        List<ProjectDto> projectDtos = fakeDataGeneratorApi.generateProjects(generationTarget).stream()
                .map(Converter::convert)
                .toList();
        return ResponseEntity.ok(projectDtos);
    }
}
