package ship.it.goodgolems.api.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ship.it.goodgolems.api.rest.presentation.Converter;
import ship.it.goodgolems.api.rest.presentation.EmployeeDto;
import ship.it.goodgolems.core.FakeDataGeneratorServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final FakeDataGeneratorServiceImpl fakeDataGeneratorServiceImpl;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesFromH2() {
        List<EmployeeDto> employeeDtos = fakeDataGeneratorServiceImpl.getAllEmployees()
                .stream()
                .map(Converter::convert)
                .toList();
        return ResponseEntity.ok(employeeDtos);
    }

}
