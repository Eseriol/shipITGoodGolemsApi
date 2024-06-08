package ship.it.goodgolems.core;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ship.it.goodgolems.api.AiSuggestionApi;
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.spi.ai.model.EmployeeSuggester;
import ship.it.goodgolems.spi.ai.model.ProjectSuggester;
import ship.it.goodgolems.spi.storage.EmployeeStorage;
import ship.it.goodgolems.spi.storage.ProjectStorage;

@Slf4j
@Service
public class SuggestionService implements AiSuggestionApi {

    private EmployeeStorage employeeStorage;
    private ProjectStorage projectStorage;
    private final EmployeeSuggester employeeSuggester;
    private final ProjectSuggester projectSuggester;

    @Autowired
    public SuggestionService(EmployeeSuggester employeeSuggester, ProjectSuggester projectSuggester) {
        this(null, null, employeeSuggester, projectSuggester);
    }
    public SuggestionService(EmployeeStorage employeeStorage, ProjectStorage projectStorage,
            EmployeeSuggester employeeSuggester, ProjectSuggester projectSuggester) {
        this.employeeStorage = employeeStorage;
        this.projectStorage = projectStorage;
        this.employeeSuggester = employeeSuggester;
        this.projectSuggester = projectSuggester;
    }

    @Autowired
    public SuggestionService setEmployeeStorage(EmployeeStorage employeeStorage) {
        this.employeeStorage = employeeStorage;
        return this;
    }

    @Autowired
    public SuggestionService setProjectStorage(ProjectStorage projectStorage) {
        this.projectStorage = projectStorage;
        return this;
    }

    @Override
    public Map<Project, Set<Employee>> suggestEmployees(Collection<Project> projects) {

        Set<Employee> employees = Optional.ofNullable(employeeStorage)
                .orElseGet(MockEmployeeStorage::new)
                .getAvailableEmployees();
        if (employees.isEmpty()) {
            log.warn("No available employees found");
            return Map.of();
        }
        return employeeSuggester.sagestEmployeesForProjects(projects, employees).orElseGet(
                () -> {
                    log.warn("No suggested employees found");
                    return Map.of();
                });
    }

    @Override
    public Set<Project> suggestProjects(Employee employee) {
        return projectSuggester.findProjectsForEmployee(employee, Optional.ofNullable(projectStorage)
                        .orElseGet(MockProjectStorage::new).getProjects())
                .orElseGet(() -> {
                    log.warn("No suggested projects found");
                    return Set.of();
                });
    }

    class MockEmployeeStorage implements EmployeeStorage {
        @Override
        public Set<Employee> getEmployees() {
            return Set.of();
        }

        @Override
        public Set<Employee> getAvailableEmployees() {
            return Set.of();
        }
    }


    class MockProjectStorage implements ProjectStorage {
        @Override
        public Set<Project> getProjects() {
            return Set.of();
        }
    }
}
