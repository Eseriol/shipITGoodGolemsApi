package ship.it.goodgolems.api.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ship.it.goodgolems.api.rest.presentation.Converter;
import ship.it.goodgolems.api.rest.presentation.EmployeeDto;
import ship.it.goodgolems.core.FakeDataGeneratorServiceImpl;
import ship.it.goodgolems.jpa.model.EmployeeEntity;
import ship.it.goodgolems.jpa.service.EmployeeStorageServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final FakeDataGeneratorServiceImpl fakeDataGeneratorServiceImpl;
    private final EmployeeStorageServiceImpl employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesFromH2() {
        List<EmployeeDto> employeeDtos = fakeDataGeneratorServiceImpl.getAllEmployees()
                .stream()
                .map(Converter::convert)
                .toList();
        return ResponseEntity.ok(employeeDtos);
    }

    @GetMapping("/by-technology")
    public List<EmployeeEntity> getEmployeesByTechnology(@RequestParam String technologyName) {
        return employeeService.getEmployeesByTechnology(technologyName);
    }

    @GetMapping("/by-position")
    public List<EmployeeEntity> getEmployeesByPosition(@RequestParam String position) {
        return employeeService.getEmployeesByPosition(position);
    }

    @GetMapping("/by-project-name")
    public List<EmployeeEntity> getEmployeesByProjectName(@RequestParam String projectName) {
        return employeeService.getEmployeesByProjectName(projectName);
    }

    @GetMapping("/by-technology-and-min-years")
    public List<EmployeeEntity> getEmployeesByTechnologyAndMinYears(@RequestParam String technologyName, @RequestParam int years) {
        return employeeService.getEmployeesByTechnologyAndMinYears(technologyName, years);
    }

    @GetMapping("/by-project-id")
    public List<EmployeeEntity> getEmployeesByProjectId(@RequestParam Long projectId) {
        return employeeService.getEmployeesByProjectId(projectId);
    }

    @GetMapping("/by-full-name")
    public List<EmployeeEntity> getEmployeesByFullName(@RequestParam String fullName) {
        return employeeService.getEmployeesByFullName(fullName);
    }

    @GetMapping("/by-technology-names")
    public List<EmployeeEntity> getEmployeesByTechnologyNames(@RequestParam List<String> technologyNames) {
        return employeeService.getEmployeesByTechnologyNames(technologyNames);
    }

    @GetMapping("/by-project-requirement")
    public List<EmployeeEntity> getEmployeesByProjectRequirement(@RequestParam String technologyName) {
        return employeeService.getEmployeesByProjectRequirement(technologyName);
    }

    @GetMapping("/by-seniority-level")
    public List<EmployeeEntity> getEmployeesBySeniorityLevel(@RequestParam String seniorityLevel) {
        return employeeService.getEmployeesBySeniorityLevel(seniorityLevel);
    }

    @GetMapping("/by-stack-and-min-years")
    public List<EmployeeEntity> getEmployeesByStackAndMinYears(@RequestParam String technologyName, @RequestParam int years) {
        return employeeService.getEmployeesByStackAndMinYears(technologyName, years);
    }

    @GetMapping("/by-number-of-projects-greater-than")
    public List<EmployeeEntity> getEmployeesByNumberOfProjectsGreaterThan(@RequestParam int numberOfProjects) {
        return employeeService.getEmployeesByNumberOfProjectsGreaterThan(numberOfProjects);
    }

}
