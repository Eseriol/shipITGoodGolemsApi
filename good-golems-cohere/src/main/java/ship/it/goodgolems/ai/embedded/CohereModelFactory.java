package ship.it.goodgolems.ai.embedded;

import org.springframework.ai.bedrock.cohere.BedrockCohereEmbeddingModel;
import org.springframework.ai.bedrock.cohere.api.CohereEmbeddingBedrockApi;
import org.springframework.ai.embedding.EmbeddingModel;

import com.fasterxml.jackson.databind.ObjectMapper;

import ship.it.goodgolems.spi.ai.embedded.EmbeddedModelFactory;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;

public class CohereModelFactory implements EmbeddedModelFactory<EmbeddingModel> {

    public EmbeddingModel createEmbeddingModel() {
        var cohereEmbeddingApi =new CohereEmbeddingBedrockApi(
                CohereEmbeddingBedrockApi.CohereEmbeddingModel.COHERE_EMBED_MULTILINGUAL_V1.id(),
                EnvironmentVariableCredentialsProvider.create(), Region.EU_CENTRAL_1.id(), new ObjectMapper());
        return new BedrockCohereEmbeddingModel(cohereEmbeddingApi);
    }

}
