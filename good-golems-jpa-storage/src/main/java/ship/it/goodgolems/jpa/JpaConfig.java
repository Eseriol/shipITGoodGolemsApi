package ship.it.goodgolems.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration class for JPA.
 * This class enables JPA repositories, scans and maps entities, and enables transaction management.
 */
@Configuration
@EnableJpaRepositories
@EntityScan(basePackages = "ship.it.goodgolems.jpa.model")
@EnableTransactionManagement
public class JpaConfig {
}
