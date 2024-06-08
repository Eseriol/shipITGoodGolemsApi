package ship.it.goodgolems.domain;

import org.springframework.util.Assert;

public record Stack(
        String technologyName
) {
    public Stack {
//        Assert.hasText(technologyName, "Name of technology must not be empty");
    }
}
