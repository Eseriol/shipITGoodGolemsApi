package ship.it.goodgolems.api;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;

import java.util.List;

public interface FakeDataGeneratorApi {

    List<Employee> generateEmployees(int noGen);

    List<Project> generateProjects(int noGen);

}
