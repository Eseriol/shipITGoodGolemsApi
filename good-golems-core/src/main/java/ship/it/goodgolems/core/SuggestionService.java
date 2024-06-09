package ship.it.goodgolems.core;

import java.util.Collection;
import java.util.List;
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

        Set<Employee> employees = employeeStorage
                .getAvailableEmployees();
        if (employees.isEmpty()) {
            log.warn("No available employees found");
            return Map.of();
        }
        List<VectorStoreDocument> storedEmployees = vectorStoregeService.store(employees);
        try {
            return employeeSuggester.sagestEmployeesForProjects(projects).orElseGet(
                    () -> {
                        log.warn("No suggested employees found");
                        return Map.of();
                    });
        } finally {
            vectorStoregeService.delete(storedEmployees.stream().map(VectorStoreDocument::id).toList());
        }
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
