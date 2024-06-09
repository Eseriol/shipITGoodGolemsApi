package ship.it.goodgolems.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ship.it.goodgolems.api.AiSuggestionApi;
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.domain.ai.VectorStoreDocument;
import ship.it.goodgolems.spi.ai.model.EmployeeSuggester;
import ship.it.goodgolems.spi.ai.model.ProjectSuggester;
import ship.it.goodgolems.spi.storage.EmployeeStorage;
import ship.it.goodgolems.spi.storage.ProjectStorage;
import ship.it.goodgolems.spi.vectordb.VectorStoregeService;

@Slf4j
@Service
@RequiredArgsConstructor
public class SuggestionService implements AiSuggestionApi {

    private final EmployeeStorage employeeStorage;
    private final ProjectStorage projectStorage;
    private final EmployeeSuggester employeeSuggester;
    private final ProjectSuggester projectSuggester;

    private final VectorStoregeService vectorStoregeService;


    @Override
    public Map<Project, Set<Employee>> suggestEmployees(Collection<Project> projects) {

        Set<Employee> employees = employeeStorage.getAvailableEmployees();
        if (employees.isEmpty()) {
            log.warn("No available employees found");
            return Map.of();
        }
        Map<Project, Set<Employee>> suggestedEmployees = new HashMap<>();
        for (Project project : projects) {
            var storedEmployees = vectorStoregeService.store(employees);
            try {
                Set<Employee> suggested = findSuggestedEmployees(project, employees);
                suggestedEmployees.put(project, suggested);
                employees.removeAll(suggested);
            } catch (Exception e){
                log.error(e.getMessage(), e);
            }finally {
                vectorStoregeService.delete(storedEmployees.stream()
                        .map(VectorStoreDocument::id)
                        .toList());
            }
        }
        return suggestedEmployees;

    }

    private Set<Employee> findSuggestedEmployees(Project project, Set<Employee> employees) {
        return employeeSuggester.sagestEmployeesForProject(project, employees)
                .orElseGet(() -> {
                    log.warn("No suggested employees found for project: {}", project.name());
                    return Set.of();
                });
    }

    @Override
    public Set<Project> suggestProjects(Employee employee) {
        return projectSuggester.findProjectsForEmployee(employee, projectStorage.getProjects())
                .orElseGet(() -> {
                    log.warn("No suggested projects found");
                    return Set.of();
                });
    }

}
