package ship.it.goodgolems.domain;

/**
 * The ExperiencedCount class represents the number of employees with a specific number of years of experience.
 * It includes the years of experience and the count of employees with that experience.
 */
public record ExperiencedCount(
        int yearsOfExperience,
        int countOfEmployee
) {

    public ExperiencedCount {
        yearsOfExperience = yearsOfExperience < 0 ? 0 : yearsOfExperience;
        countOfEmployee = countOfEmployee < 0 ? 0 : countOfEmployee;
    }
}
