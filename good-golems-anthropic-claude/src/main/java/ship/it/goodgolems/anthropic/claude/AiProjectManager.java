package ship.it.goodgolems.anthropic.claude;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Component;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.spi.ai.model.ProjectSuggester;

@Component
public class AiProjectManager implements ProjectSuggester {
    @Override
    public Optional<Set<Project>> findProjectsForEmployee(Employee employee) {
        return Optional.empty();
    }

    @Override
    public Optional<Set<Project>> findProjectsForEmployee(Employee employee, Collection<Project> projects) {
        return Optional.empty();
    }
}
