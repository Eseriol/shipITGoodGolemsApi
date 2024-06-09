package ship.it.goodgolems.api;

import java.util.List;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Project;

/**
 * FakeDataGeneratorApi is an interface that provides methods for generating fake data.
 */
public interface FakeDataGeneratorApi {

    /**
     * Generates a list of fake employees.
     *
     * @param noGen the number of employees to generate
     * @return the list of generated employees
     */
    List<Employee> generateEmployees(int noGen);

    /**
     * Generates a list of fake projects.
     *
     * @param noGen the number of projects to generate
     * @return the list of generated projects
     */
    List<Project> generateProjects(int noGen);

}
