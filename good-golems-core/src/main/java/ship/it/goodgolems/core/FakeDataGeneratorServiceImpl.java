package ship.it.goodgolems.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.FakeDataGeneratorApi;
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.jpa.mapper.EmployeeMapper;
import ship.it.goodgolems.jpa.mapper.ProjectMapper;
import ship.it.goodgolems.jpa.repository.EmployeeRepository;
import ship.it.goodgolems.jpa.repository.ProjectRepository;

/**
 * FakeDataGeneratorServiceImpl is a service class that generates fake data for employees and projects.
 */
@Component
@RequiredArgsConstructor
@Data
public class FakeDataGeneratorServiceImpl {
    @Value("${application.autostart.fake-employee-number}")
    private int fakeEmployeeNumber;
    @Value("${application.autostart.fake-project-number}")
    private int fakeProjectNumber;
    private final EmployeeMapper employeeMapper;
    private final ProjectMapper projectMapper;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    private final FakeDataGeneratorApi fakeDataGeneratorApi;

    /**
     * This method is responsible for generating fake employees and projects.
     * It utilizes the FakeDataGeneratorApi to generate the data and then maps them to the corresponding entities
     * using the EmployeeMapper and ProjectMapper.
     *
     * The generated employees are then saved to the EmployeeRepository using the `saveAll` method,
     * and the generated projects are saved to the ProjectRepository using the same method.
     *
     * This method is annotated with @PostConstruct, which means it will be executed automatically
     * after the bean is initialized.
     */
    @PostConstruct
    public void generateFakeEmployees(){
        employeeRepository.saveAll(fakeDataGeneratorApi
                .generateEmployees(this.fakeEmployeeNumber)
                .stream()
                .map(employeeMapper::map)
                .toList());
        projectRepository.saveAll(fakeDataGeneratorApi
                .generateProjects(this.fakeProjectNumber)
                .stream()
                .map(projectMapper::map)
                .toList());
    }

    /**
     * Retrieves all employees from the database.
     *
     * @return A list of Employee objects representing the retrieved employees.
     */
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::map)
                .toList();
    }

    /**
     * Retrieves all projects from the database.
     *
     * @return A list of Project objects representing the retrieved projects.
     */
    public List<Project> getAllProjects(){
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::map)
                .toList();
    }
}
