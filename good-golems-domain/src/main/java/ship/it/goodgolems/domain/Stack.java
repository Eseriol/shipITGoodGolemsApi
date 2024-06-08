package ship.it.goodgolems.domain;

import java.util.Optional;

public record Stack(
        String technologyName
) {
    public Stack {
        technologyName = Optional.ofNullable(technologyName).orElse("");
    }
}
