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
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class FakeDataGeneratorController {

    private final FakeDataGeneratorApi fakeDataGeneratorApi;

    @PostMapping("/faker/Employees")
    public ResponseEntity<List<EmployeeDto>> fakeEmployeesDataGen(@RequestParam int noGen) {
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee : fakeDataGeneratorApi.generateEmployees(noGen)) {
            employeeDtos.add(Converter.convert(employee));
        }

        return ResponseEntity.ok(employeeDtos);
    }

    @PostMapping("/faker/Project")
    public ResponseEntity<List<Project>> fakeProjectDataGen(@RequestParam int noGen) {
        List<Project> projects = fakeDataGeneratorApi.generateProjects(noGen);
        return ResponseEntity.ok(projects);
    }
}
