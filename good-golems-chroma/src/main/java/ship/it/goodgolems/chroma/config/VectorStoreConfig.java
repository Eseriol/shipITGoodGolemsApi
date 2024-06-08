package ship.it.goodgolems.chroma.config;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.spi.ai.embedded.EmbeddedModelFactory;

@Configuration
@RequiredArgsConstructor
public class VectorStoreConfig {

    private final EmbeddedModelFactory<EmbeddingModel> embeddedModelFactory;


    @Bean
    public EmbeddingModel embeddingModel() {
        return embeddedModelFactory.createEmbeddingModel();
    }

}
