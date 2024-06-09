package ship.it.goodgolems.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ship.it.goodgolems.api.AiSuggestionApi;
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.domain.ai.TeamSuggestion;
import ship.it.goodgolems.domain.ai.VectorStoreDocument;
import ship.it.goodgolems.spi.ai.model.EmployeeSuggester;
import ship.it.goodgolems.spi.storage.EmployeeStorage;
import ship.it.goodgolems.spi.storage.ProjectStorage;
import ship.it.goodgolems.spi.vectordb.VectorStoregeService;

/**
 * The SuggestionService class is responsible for providing suggestions for employees to be assigned to projects.
 * It implements the AiSuggestionApi interface.
 *
 * Before using this service, make sure to configure the required dependencies and properties.
 *
 * Usage:
 * SuggestionService suggestionService = new SuggestionService(employeeStorage, projectStorage, employeeSuggester, vectorStoregeService);
 *
 * // Get team suggestion for a specific project
 * TeamSuggestion teamSuggestion = suggestionService.suggestEmployees(projectId);
 *
 * // Get suggestions for multiple projects
 * Map<Project, Set<Employee>> suggestedEmployees = suggestionService.suggestEmployees(projects, usingRAG);
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SuggestionService implements AiSuggestionApi {

    @Value("${spring.ai.rag:false}")
    private boolean useRag;

    private final EmployeeStorage employeeStorage;
    private final ProjectStorage projectStorage;
    private final EmployeeSuggester employeeSuggester;

    private final VectorStoregeService vectorStoregeService;

    /**
     * Retrieves a team suggestion based on a given project ID.
     *
     * @param projectId the ID of the project to suggest employees for
     * @return the suggested team for the project
     * @throws RuntimeException if the project with the given ID is not found
     */
    @Override
    public TeamSuggestion suggestEmployees(Long projectId) {
        var project = projectStorage.getProjectById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));
        var team = suggestEmployees(List.of(project), useRag).get(project);
        return new TeamSuggestion(project, team);
    }

    /**
     * Suggests employees for each project based on the given collection of projects and the flag indicating whether to use RAG (Red, Amber, Green) system.
     *
     * @param projects   the collection of projects
     * @param usingRAG   flag indicating whether to use RAG system
     * @return a map containing suggested employees for each project
     */
    @Override
    public Map<Project, Set<Employee>> suggestEmployees(Collection<Project> projects, boolean usingRAG) {

        Set<Employee> employees = employeeStorage.getAvailableEmployees();
        if (employees.isEmpty()) {
            log.warn("No available employees found");
            return Map.of();
        }
        Map<Project, Set<Employee>> suggestedEmployees = new HashMap<>();
        for (Project project : projects) {
            List<VectorStoreDocument> storedEmployees = new ArrayList<>();
            if (usingRAG) {
                storedEmployees = vectorStoregeService.store(employees);
            }
            try {
                Set<Employee> suggested = new HashSet<>(
                        Optional.ofNullable(findSuggestedEmployees(project, employees, usingRAG))
                                .orElseGet(Collections::emptyList));
                suggestedEmployees.put(project, suggested);
                employees.removeAll(suggested);
            } catch (Exception e){
                log.error(e.getMessage(), e);
            } finally {
                if (usingRAG) {
                    vectorStoregeService.delete(storedEmployees.stream()
                            .map(VectorStoreDocument::id)
                            .toList());
                }
            }
        }
        return suggestedEmployees;

    }

    private List<Employee> findSuggestedEmployees(Project project, Set<Employee> employees, boolean usingRAG) {
        if (usingRAG) {
            return employeeSuggester.sagestEmployeesForProject(project);
        } else {
            return employeeSuggester.sagestEmployeesForProject(project, employees);
        }
    }

}
