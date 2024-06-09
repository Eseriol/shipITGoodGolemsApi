package ship.it.goodgolems.anthropic.claude;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.anthropic.claude.prompt.TeamPrompts;
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.spi.ai.model.EmployeeSuggester;

/**
 * The AiPeopleManager class is responsible for suggesting employees for a project using an AI chat client.
 * It implements the EmployeeSuggester interface.
 */
@Component
@RequiredArgsConstructor
public class AiPeopleManager implements EmployeeSuggester {

    private final AiFacade aiFacade;

    /**
     * Returns an explanation of why the given team members are suggested for the project.
     * Uses the AI chat client to get the response based on a prompt.
     *
     * @param project      the project for which team members are suggested
     * @param teamMembers  the collection of team members to explain the suggestion for
     * @return an explanation of why the team members are suggested
     */
    @Override
    public String explainSuggestion(Project project, Collection<Employee> teamMembers) {
        var prompt = TeamPrompts.SUGGEST_TEAM.render(Map.of(
                "project", project.toString(),
                "employees", teamMembers
        ));
        return aiFacade.getResponseAsString(prompt);
    }

    /**
     * Returns a list of suggested employees for the given project.
     *
     * @param project the project for which employees are suggested
     * @return a list of suggested employees
     */
    @Override
    public List<Employee> sagestEmployeesForProject(Project project) {
        var prompt = TeamPrompts.ADVISE_TEAM.render(Map.of(
                "project", project.toString()
        ));
        return aiFacade.adviseResponse(prompt, new ParameterizedTypeReference<>() {
        });
    }

    /**
     * Returns a list of suggested employees for the given project and collection of employees.
     *
     * @param project   the project for which employees are suggested
     * @param employees the collection of employees to choose from
     * @return a list of suggested employees
     */
    @Override
    public List<Employee> sagestEmployeesForProject(Project project, Collection<Employee> employees) {
        var prompt = TeamPrompts.SUGGEST_TEAM.render(Map.of(
                "project", project.toString(),
                "employees", employees
        ));
        return aiFacade.getResponse(prompt, new ParameterizedTypeReference<>() {
        });
    }

}
