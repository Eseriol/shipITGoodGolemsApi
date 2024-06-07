package ship.it.good_golems.config;

import org.springframework.ai.bedrock.cohere.BedrockCohereEmbeddingModel;
import org.springframework.ai.bedrock.cohere.api.CohereEmbeddingBedrockApi;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;

@Configuration
public class VectorStoreConfig {

    @Bean
    public EmbeddingModel embeddingModel() {
        var cohereEmbeddingApi =new CohereEmbeddingBedrockApi(
                CohereEmbeddingBedrockApi.CohereEmbeddingModel.COHERE_EMBED_MULTILINGUAL_V1.id(),
                EnvironmentVariableCredentialsProvider.create(), Region.EU_CENTRAL_1.id(), new ObjectMapper());
        return new BedrockCohereEmbeddingModel(cohereEmbeddingApi);
    }

}
