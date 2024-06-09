package ship.it.goodgolems.anthropic.claude;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Component;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.spi.ai.model.EmployeeSuggester;

@Component
public class AiPeopleManager implements EmployeeSuggester {

    @Override
    public Optional<Set<Employee>> sagestEmployeesForProject(Project project) {
        return Optional.empty();
    }

    @Override
    public Optional<Set<Employee>> sagestEmployeesForProject(Project project, Collection<Employee> employees) {
        return Optional.empty();
    }

}
