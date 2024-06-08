package ship.it.goodgolems.domain;

import java.util.Optional;

public record Experience(
        Stack stack,
        int years
) {

    public Experience {
        stack = Optional.ofNullable(stack).orElse(new Stack(""));
        years = years < 0 ? 0 : years;
    }
}
