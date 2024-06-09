package ship.it.goodgolems.core.providers;

import net.datafaker.Faker;

/**
 * CustomFaker is a subclass of the Faker library that provides additional custom functionality.
 */
public class CustomFaker extends Faker {

    /**
     * Returns an instance of Provider class.
     * @return An instance of Provider class.
     */
    public Provider provider() {
        return getProvider(Provider.class, Provider::new, this);
    }

}
