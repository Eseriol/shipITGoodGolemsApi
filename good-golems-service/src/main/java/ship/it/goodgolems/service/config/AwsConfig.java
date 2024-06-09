package ship.it.goodgolems.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;

/**
 * This class provides AWS configuration beans for the application.
 */
@Configuration
public class AwsConfig {

    @Bean
    public Region awsRegion() {
        return Region.EU_CENTRAL_1;
    }

    @Bean
    public EnvironmentVariableCredentialsProvider credentialsProvider() {
        return EnvironmentVariableCredentialsProvider.create();
    }
}
