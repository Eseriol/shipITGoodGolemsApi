package ship.it.goodgolems.core;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ship.it.goodgolems.api.FakeDataGeneratorApi;
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.jpa.mapper.EmployeeMapper;
import ship.it.goodgolems.jpa.mapper.ProjectMapper;
import ship.it.goodgolems.jpa.model.EmployeeEntity;
import ship.it.goodgolems.jpa.model.ProjectEntity;
import ship.it.goodgolems.jpa.repository.EmployeeRepository;
import ship.it.goodgolems.jpa.repository.ProjectRepository;

import java.util.List;

@Component
@Data
public class FakeDataGeneratorServiceImpl {
    @Value("${application.autostart.fake-employee-number}")
    private int fakeEmployeeNumber;
    @Value("${application.autostart.fake-project-number}")
    private int fakeProjectNumber;
    private List<Employee> fakeEmployees;
    private List<EmployeeEntity> fakeEmployeesEntity;
    private List<Project> fakeProjects;
    private List<ProjectEntity> fakeProjectsEntity;
    private final EmployeeMapper employeeMapper;
    private final ProjectMapper projectMapper;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    private final FakeDataGeneratorApi fakeDataGeneratorApi;

    public FakeDataGeneratorServiceImpl(FakeDataGeneratorApi fakeDataGeneratorApi, EmployeeMapper employeeMapper, ProjectMapper projectMapper, EmployeeRepository employeeRepository, ProjectRepository projectRepository){
        this.fakeDataGeneratorApi=fakeDataGeneratorApi;
        this.employeeMapper = employeeMapper;
        this.projectMapper = projectMapper;
        this.employeeRepository=employeeRepository;
        this.projectRepository = projectRepository;
    }

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
}
