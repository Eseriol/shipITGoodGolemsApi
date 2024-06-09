package ship.it.goodgolems.core;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ship.it.goodgolems.api.FakeDataGeneratorApi;
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.jpa.mapper.EmployeeMapper;
import ship.it.goodgolems.jpa.mapper.ProjectMapper;
import ship.it.goodgolems.jpa.repository.EmployeeRepository;
import ship.it.goodgolems.jpa.repository.ProjectRepository;

import java.util.List;

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

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::map)
                .toList();
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::map)
                .toList();
    }
}
