package ship.it.goodgolems.core;

import org.springframework.stereotype.Service;
import ship.it.goodgolems.api.FakeDataGeneratorApi;
import ship.it.goodgolems.core.providers.CustomFaker;
import ship.it.goodgolems.domain.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FakeDataGeneratorService implements FakeDataGeneratorApi {

    private final CustomFaker customFaker = new CustomFaker();

    private static final int MAX_EMPLOYEE_STACK_NUMBER = 10;
    private static final int MAX_EMPLOYEE_EXPERIENCE_PER_STACK = 15;

    private static final int MAX_PROJECT_REQUIREMENTS_NUMBER = 10;
    private static final int MAX_PROJECT_REQUIRED_EXPERIENCE_PER_STACK = 5;
    private static final int MAX_PROJECT_REQUIRED_EMPLOYEE_PER_STACK = 5;
    private static final int MAX_PROJECT_REQUIRED_STACK_PER_SENIORITY = 5;

    @Override
    public List<Employee> generateEmployees(int generationRequested) {
        return IntStream.range(0, generationRequested)
                .mapToObj(i -> {
                    Set<Experience> experiences = IntStream.range(0, customFaker.number().numberBetween(1, MAX_EMPLOYEE_STACK_NUMBER))
                            .mapToObj(j -> {
                                String programmingLanguage = customFaker.provider().stack();
                                Stack stack = new Stack(programmingLanguage);

                                return new Experience(
                                        stack,
                                        customFaker.number().numberBetween(1, MAX_EMPLOYEE_EXPERIENCE_PER_STACK)
                                );
                            })
                            .collect(Collectors.toSet());

                    return new Employee(
                            customFaker.name().fullName(),
                            customFaker.provider().profession(),
                            experiences,
                            generateProjects(1).get(0)
                    );
                })
                .toList();
    }

    @Override
    public List<Project> generateProjects(int generationRequested) {
        return IntStream.range(0, generationRequested)
                .mapToObj(i -> {
                    Set<ProjectRequirement> projectRequirements = IntStream.range(0, customFaker.number().numberBetween(1, MAX_PROJECT_REQUIREMENTS_NUMBER))
                            .mapToObj(j -> {
                                Stack stack = new Stack(customFaker.provider().stack());

                                Set<ExperiencedCount> experiencedCount = IntStream.range(0, customFaker.number().numberBetween(1, MAX_PROJECT_REQUIRED_STACK_PER_SENIORITY))
                                        .mapToObj(k -> new ExperiencedCount(
                                                customFaker.number().numberBetween(1, MAX_PROJECT_REQUIRED_EXPERIENCE_PER_STACK),
                                                customFaker.number().numberBetween(1, MAX_PROJECT_REQUIRED_EMPLOYEE_PER_STACK)
                                        ))
                                        .collect(Collectors.toSet());

                                return new ProjectRequirement(stack, experiencedCount);
                            })
                            .collect(Collectors.toSet());

                    return Project.builder()
                            .name(customFaker.provider().project())
                            .requirements(projectRequirements)
                            .build();
                })
                .toList();
    }
}