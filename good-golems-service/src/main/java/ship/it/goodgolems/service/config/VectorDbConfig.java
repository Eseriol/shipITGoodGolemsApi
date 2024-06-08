package ship.it.goodgolems.service.config;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ship.it.goodgolems.ai.embedded.CohereModelFactory;
import ship.it.goodgolems.spi.ai.embedded.EmbeddedModelFactory;

@Configuration
public class VectorDbConfig {

    @Bean
    public EmbeddedModelFactory<EmbeddingModel> embeddedModelFactory() {
        return new CohereModelFactory();
    }

}
