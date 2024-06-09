package ship.it.goodgolems.api.rest.presentation;

import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.Experience;
import ship.it.goodgolems.domain.ExperiencedCount;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.domain.ProjectRequirement;
import ship.it.goodgolems.domain.Stack;


/**
 * The Converter class provides static methods for converting between different data transfer objects (DTOs)
 * and domain objects.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Converter {

    public static StackDto convert(Stack stack) {
        return new StackDto(stack.technologyName());
    }

    public static Stack convert(StackDto stackDto) {
        return new Stack(stackDto.technologyName());
    }

    public static ExperiencedCountDto convert(ExperiencedCount experiencedCount) {
        return new ExperiencedCountDto(experiencedCount.yearsOfExperience(), experiencedCount.countOfEmployee());
    }

    public static ExperiencedCount convert(ExperiencedCountDto experiencedCountDto) {
        return new ExperiencedCount(experiencedCountDto.yearsOfExperience(), experiencedCountDto.countOfEmployee());
    }

    public static ProjectRequirementDto convert(ProjectRequirement projectRequirement) {
        return new ProjectRequirementDto(convert(projectRequirement.stack()), projectRequirement.experiencedCount()
                .stream()
                .map(Converter::convert)
                .collect(Collectors.toSet()));
    }

    public static ProjectRequirement convert(ProjectRequirementDto projectRequirementDto) {
        return new ProjectRequirement(convert(projectRequirementDto.stack()), projectRequirementDto.experiencedCount()
                .stream()
                .map(Converter::convert)
                .collect(Collectors.toSet()));
    }

    public static ExperienceDto convert(Experience experience) {
        return new ExperienceDto(convert(experience.stack()), experience.years());
    }

    public static Experience convert(ExperienceDto experienceDto) {
        return new Experience(convert(experienceDto.stack()), experienceDto.years());
    }

    public static EmployeeDto convert(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.id())
                .fullName(employee.fullName())
                .position(employee.position())
                .experience(employee.experience()
                        .stream()
                        .map(Converter::convert)
                        .collect(Collectors.toSet()))
                .build();
    }

    public static Employee convert(EmployeeDto employeeDto) {
        return Employee.builder()
                .id(employeeDto.id())
                .fullName(employeeDto.fullName())
                .position(employeeDto.position())
                .experience(employeeDto.experience()
                        .stream()
                        .map(Converter::convert)
                        .collect(Collectors.toSet()))
                .build();
    }

    public static ProjectDto convert(Project project) {
        return ProjectDto.builder()
                .id(project.id())
                .name(project.name())
                .employees(project.employees()
                        .stream()
                        .map(Converter::convert)
                        .collect(Collectors.toSet()))
                .requirements(project.requirements()
                        .stream()
                        .map(Converter::convert)
                        .collect(Collectors.toSet()))
                .build();
    }

    public static Project convert(ProjectDto projectDto) {
        return Project.builder()
                .id(projectDto.id())
                .name(projectDto.name())
                .employees(projectDto.employees()
                        .stream()
                        .map(Converter::convert)
                        .collect(Collectors.toSet()))
                .requirements(projectDto.requirements()
                        .stream()
                        .map(Converter::convert)
                        .collect(Collectors.toSet()))
                .build();
    }
}
