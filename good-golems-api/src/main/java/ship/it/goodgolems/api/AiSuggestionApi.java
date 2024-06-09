package ship.it.goodgolems.api;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.domain.ai.TeamSuggestion;

public interface AiSuggestionApi {

    Map<Project, Set<Employee>> suggestEmployees(final Collection<Project> projects, boolean usingRAG);

    TeamSuggestion suggestEmployees(Long projectId);

}
