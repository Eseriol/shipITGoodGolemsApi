package ship.it.goodgolems.api.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.rest.presentation.Converter;
import ship.it.goodgolems.api.rest.presentation.EmployeeDto;
import ship.it.goodgolems.core.FakeDataGeneratorServiceImpl;
import ship.it.goodgolems.jpa.model.EmployeeEntity;
import ship.it.goodgolems.jpa.service.EmployeeStorageServiceImpl;

/**
 * EmployeeController is a REST controller class that provides endpoints for managing employees.
 *
 * Each endpoint handles specific operations related to employees, such as retrieving employee details and filtering employees based on various criteria.
 *
 * The API endpoints are secured and can be accessed using the 'api/v1/employees' base path.
 *
 * This class requires the FakeDataGeneratorServiceImpl and EmployeeStorageServiceImpl as dependencies.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final FakeDataGeneratorServiceImpl fakeDataGeneratorServiceImpl;
    private final EmployeeStorageServiceImpl employeeService;

    /**
     * Retrieves all employees from the H2 database.
     *
     * @return A ResponseEntity containing a list of EmployeeDto objects representing the retrieved employees.
     */
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesFromH2() {
        List<EmployeeDto> employeeDtos = fakeDataGeneratorServiceImpl.getAllEmployees()
                .stream()
                .map(Converter::convert)
                .toList();
        return ResponseEntity.ok(employeeDtos);
    }

    /**
     * Retrieves a list of employees based on the specified technology name.
     *
     * @param technologyName the name of the technology
     * @return a list of EmployeeEntity objects representing the employees
     */
    @GetMapping("/by-technology")
    public List<EmployeeEntity> getEmployeesByTechnology(@RequestParam String technologyName) {
        return employeeService.getEmployeesByTechnology(technologyName);
    }

    /**
     * Retrieves a list of employees based on the specified position.
     *
     * @param position The position of the employees to retrieve.
     * @return A list of EmployeeEntity objects representing the employees.
     */
    @GetMapping("/by-position")
    public List<EmployeeEntity> getEmployeesByPosition(@RequestParam String position) {
        return employeeService.getEmployeesByPosition(position);
    }

    /**
     * Retrieves a list of employees based on the specified project name.
     *
     * @param projectName the name of the project
     * @return a list of EmployeeEntity objects representing the employees
     */
    @GetMapping("/by-project-name")
    public List<EmployeeEntity> getEmployeesByProjectName(@RequestParam String projectName) {
        return employeeService.getEmployeesByProjectName(projectName);
    }

    /**
     * Retrieves a list of employees based on the specified technology name and minimum years of experience.
     *
     * @param technologyName The name of the technology.
     * @param years          The minimum years of experience.
     * @return A list of EmployeeEntity objects representing the employees.
     */
    @GetMapping("/by-technology-and-min-years")
    public List<EmployeeEntity> getEmployeesByTechnologyAndMinYears(@RequestParam String technologyName, @RequestParam int years) {
        return employeeService.getEmployeesByTechnologyAndMinYears(technologyName, years);
    }

    /**
     * Retrieves a list of employees based on the specified project ID.
     *
     * @param projectId the ID of the project
     * @return a list of EmployeeEntity objects representing the employees in the specified project
     */
    @GetMapping("/by-project-id")
    public List<EmployeeEntity> getEmployeesByProjectId(@RequestParam Long projectId) {
        return employeeService.getEmployeesByProjectId(projectId);
    }

    /**
     * Retrieves a list of employees based on the specified full name.
     *
     * @param fullName The full name of the employees to retrieve.
     * @return A list of EmployeeEntity objects representing the employees.
     */
    @GetMapping("/by-full-name")
    public List<EmployeeEntity> getEmployeesByFullName(@RequestParam String fullName) {
        return employeeService.getEmployeesByFullName(fullName);
    }

    /**
     * Retrieves a list of employees based on the specified technology names.
     *
     * @param technologyNames The list of technology names.
     * @return A list of EmployeeEntity objects representing the employees.
     */
    @GetMapping("/by-technology-names")
    public List<EmployeeEntity> getEmployeesByTechnologyNames(@RequestParam List<String> technologyNames) {
        return employeeService.getEmployeesByTechnologyNames(technologyNames);
    }

    /**
     * Retrieves a list of employees based on the specified project requirement.
     *
     * @param technologyName the name of the technology required for the project
     * @return a list of EmployeeEntity objects representing the employees matching the project requirement
     */
    @GetMapping("/by-project-requirement")
    public List<EmployeeEntity> getEmployeesByProjectRequirement(@RequestParam String technologyName) {
        return employeeService.getEmployeesByProjectRequirement(technologyName);
    }

    /**
     * Retrieves a list of employees based on the specified seniority level.
     *
     * @param seniorityLevel The seniority level of the employees to retrieve.
     * @return A list of EmployeeEntity objects representing the employees.
     */
    @GetMapping("/by-seniority-level")
    public List<EmployeeEntity> getEmployeesBySeniorityLevel(@RequestParam String seniorityLevel) {
        return employeeService.getEmployeesBySeniorityLevel(seniorityLevel);
    }

    /**
     * Retrieves a list of employees based on the specified technology name and minimum years of experience.
     *
     * @param technologyName The name of the technology.
     * @param years The minimum years of experience.
     * @return A list of EmployeeEntity objects representing the employees.
     */
    @GetMapping("/by-stack-and-min-years")
    public List<EmployeeEntity> getEmployeesByStackAndMinYears(@RequestParam String technologyName, @RequestParam int years) {
        return employeeService.getEmployeesByStackAndMinYears(technologyName, years);
    }

    /**
     * Retrieves a list of employees whose number of projects is greater than the specified value.
     *
     * @param numberOfProjects The minimum number of projects.
     * @return A list of EmployeeEntity objects representing the employees.
     */
    @GetMapping("/by-number-of-projects-greater-than")
    public List<EmployeeEntity> getEmployeesByNumberOfProjectsGreaterThan(@RequestParam int numberOfProjects) {
        return employeeService.getEmployeesByNumberOfProjectsGreaterThan(numberOfProjects);
    }

}
