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

@Component
@RequiredArgsConstructor
public class AiPeopleManager implements EmployeeSuggester {

    private final AiFacade aiFacade;

    @Override
    public List<Employee> sagestEmployeesForProject(Project project) {
        var prompt = TeamPrompts.ADVISE_TEAM.render(Map.of(
                "project", project.toString()
        ));
        return aiFacade.adviseResponse(prompt, new ParameterizedTypeReference<>() {
        });
    }

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
