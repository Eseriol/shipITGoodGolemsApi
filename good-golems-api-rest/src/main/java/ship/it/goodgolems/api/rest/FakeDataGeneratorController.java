package ship.it.goodgolems.api.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ship.it.goodgolems.api.FakeDataGeneratorApi;
import ship.it.goodgolems.api.rest.presentation.Converter;
import ship.it.goodgolems.api.rest.presentation.EmployeeDto;
import ship.it.goodgolems.api.rest.presentation.ProjectDto;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/faker")
public class FakeDataGeneratorController {

    private final FakeDataGeneratorApi fakeDataGeneratorApi;


    @PostMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> fakeEmployeesDataGen(@RequestParam int generationTarget) {

        List<EmployeeDto> employeeDtos = fakeDataGeneratorApi.generateEmployees(generationTarget).stream()
                .map(Converter::convert)
                .toList();
        return ResponseEntity.ok(employeeDtos);
    }

    @PostMapping("/project")
    public ResponseEntity<List<ProjectDto>> fakeProjectDataGen(@RequestParam int generationTarget) {
        List<ProjectDto> projectDtos = fakeDataGeneratorApi.generateProjects(generationTarget).stream()
                .map(Converter::convert)
                .toList();
        return ResponseEntity.ok(projectDtos);
    }
}
