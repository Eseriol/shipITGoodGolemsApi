package ship.it.goodgolems.core;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.AiSuggestionApi;
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.spi.ai.model.EmployeeSuggester;
import ship.it.goodgolems.spi.ai.model.ProjectSuggester;
import ship.it.goodgolems.spi.storage.EmployeeStorage;
import ship.it.goodgolems.spi.storage.ProjectStorage;

@Service
@RequiredArgsConstructor
public class SuggestionService implements AiSuggestionApi {

    private final EmployeeStorage employeeStorage;
    private final ProjectStorage projectStorage;
    private final EmployeeSuggester employeeSuggester;
    private final ProjectSuggester projectSuggester;

    @Override
    public Map<Project, Set<Employee>> suggestEmployees(Collection<Project> projects) {
        return Map.of();
    }

    @Override
    public Set<Project> suggestProjects(Employee employee) {
        return Set.of();
    }

    @Component
    @ConditionalOnMissingBean(EmployeeStorage.class)
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

    @Component
    @ConditionalOnMissingBean(ProjectStorage.class)
    class MockProjectStorage implements ProjectStorage {

        @Override
        public Set<Project> getProjects() {
            return Set.of();
        }
    }
}
