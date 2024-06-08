package ship.it.goodgolems.api.rest.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;

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
