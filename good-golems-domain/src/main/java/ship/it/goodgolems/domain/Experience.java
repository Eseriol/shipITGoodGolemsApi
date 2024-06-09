package ship.it.goodgolems.domain;

import java.util.Optional;

/**
 * The Experience class represents the experience of an employee.
 * It includes the technology stack and the years of experience in that stack.
 */
public record Experience(
        Stack stack,
        int years
) {

    public Experience {
        stack = Optional.ofNullable(stack).orElse(new Stack(""));
        years = years < 0 ? 0 : years;
    }
}
