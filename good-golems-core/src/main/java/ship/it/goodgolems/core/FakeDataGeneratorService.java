package ship.it.goodgolems.core;


import net.datafaker.Faker;
import org.springframework.stereotype.Service;
import ship.it.goodgolems.api.FakeDataGeneratorApi;
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Experience;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.domain.Stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FakeDataGeneratorService implements FakeDataGeneratorApi {

    private final Faker faker = new Faker();

    @Override
    public List<Employee> generateEmployees(int noGen) {
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < noGen; i++) {
            Set<Experience> exps = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                Experience exp = new Experience(
                        new Stack(faker.programmingLanguage().name()),
                        faker.number().numberBetween(1, 15)
                );
                exps.add(exp);
            }
            Employee employee = new Employee(
                    faker.name().fullName(),
                    faker.company().profession(),
                    exps,
                    null
            );

            employees.add(employee);
        }

        return employees;
    }

    @Override
    public List<Project> generateProjects(int noGen) {
        return new ArrayList<>();
    }
}