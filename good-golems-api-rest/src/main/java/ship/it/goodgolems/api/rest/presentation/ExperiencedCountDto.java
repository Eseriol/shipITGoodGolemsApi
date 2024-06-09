package ship.it.goodgolems.api.rest.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ExperiencedCountDto represents the Data Transfer Object for experienced count information.
 * It is used to transfer data between different layers of an application.
 * The class includes the years of experience and the count of employees with that experience.
 */
public record ExperiencedCountDto(
        @JsonProperty("yearsOfExperience")
        int yearsOfExperience,
        @JsonProperty("countOfEmployee")
        int countOfEmployee
) {

    public ExperiencedCountDto {
        yearsOfExperience = yearsOfExperience < 0 ? 0 : yearsOfExperience;
        countOfEmployee = countOfEmployee < 0 ? 0 : countOfEmployee;
    }
}
