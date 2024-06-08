package ship.it.goodgolems.domain;

public record ExperiencedCount(
        int yearsOfExperience,
        int countOfEmployee
) {

    public ExperiencedCount{
        yearsOfExperience = yearsOfExperience < 0 ? 0 : yearsOfExperience;
        countOfEmployee = countOfEmployee < 0 ? 0 : countOfEmployee;
    }
}
