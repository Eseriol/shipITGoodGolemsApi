package ship.it.goodgolems.core.providers;

import net.datafaker.Faker;

public class CustomFaker extends Faker {

    public Provider provider() {
        return getProvider(Provider.class, Provider::new, this);
    }

}
