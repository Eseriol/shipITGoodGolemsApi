package ship.it.goodgolems.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ship.it.goodgolems.api.VectorApi;
import ship.it.goodgolems.core.VectorService;
import ship.it.goodgolems.spi.vectordb.VectorStoregeService;

@Configuration
public class ApiConfig {

    @Bean
    public VectorApi vectorApi(VectorStoregeService vectorStoregeService) {
        return new VectorService(vectorStoregeService);
    }
}
