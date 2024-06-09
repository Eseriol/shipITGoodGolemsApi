package ship.it.goodgolems.api;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.domain.ai.TeamSuggestion;

/**
 * The AiSuggestionApi interface provides methods to suggest employees for projects.
 */
public interface AiSuggestionApi {

    /**
     * This method suggests employees for a collection of projects based on the specified criteria.
     *
     * @param projects The collection of projects for which employees need to be suggested.
     * @param usingRAG If true, the method uses the RAG (Red, Amber, Green) mechanism for employee suggestion. If false, it uses a different mechanism.
     * @return A map that maps each project to a set of suggested employees.
     */
    Map<Project, Set<Employee>> suggestEmployees(final Collection<Project> projects, boolean usingRAG);

    /**
     * This method suggests employees for a given project based on the specified criteria.
     *
     * @param projectId The ID of the project for which employees need to be suggested.
     * @return A TeamSuggestion object that contains the project and a set of suggested employees.
     */
    TeamSuggestion suggestEmployees(Long projectId);

    /**
     * This method provides an explanation or suggestion for a given project and collection of team members.
     *
     * @param project The project for which the suggestion is provided.
     * @param teamMembers The collection of team members working on the project.
     * @return The explanation or suggestion for the project.
     */
    String explainSuggestion(Project project, Collection<Employee> teamMembers);

}
