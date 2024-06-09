package ship.it.goodgolems.api.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.FakeDataGeneratorApi;
import ship.it.goodgolems.api.rest.presentation.Converter;
import ship.it.goodgolems.api.rest.presentation.EmployeeDto;
import ship.it.goodgolems.api.rest.presentation.ProjectDto;
import ship.it.goodgolems.core.FakeDataGeneratorServiceImpl;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/faker")
public class FakeDataGeneratorController {

    private final FakeDataGeneratorApi fakeDataGeneratorApi;
    private final FakeDataGeneratorServiceImpl fakeDataGeneratorServiceImpl;
    @PostMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> fakeEmployeesDataGen(@RequestParam int generationTarget) {

        List<EmployeeDto> employeeDtos = fakeDataGeneratorApi.generateEmployees(generationTarget).stream()
                .map(Converter::convert)
                .toList();
        return ResponseEntity.ok(employeeDtos);
    }
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesFromH2(){
        List<EmployeeDto> employeeDtos = fakeDataGeneratorServiceImpl.getAllEmployees()
                .stream()
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

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDto>> getAllProjectsFromH2(){
        List<ProjectDto> projectDtos = fakeDataGeneratorServiceImpl.getAllProjects()
                .stream()
                .map(Converter::convert)
                .toList();
        return ResponseEntity.ok(projectDtos);
    }
}
