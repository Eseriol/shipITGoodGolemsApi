package ship.it.goodgolems.anthropic.claude.config;

import java.time.Duration;

import org.springframework.ai.bedrock.anthropic.api.AnthropicChatBedrockApi;
import org.springframework.ai.bedrock.anthropic3.Anthropic3ChatOptions;
import org.springframework.ai.bedrock.anthropic3.BedrockAnthropic3ChatModel;
import org.springframework.ai.bedrock.anthropic3.api.Anthropic3ChatBedrockApi;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;

/**
 * Configuration class for configuring the models, APIs, and clients used in the application.
 */
@Configuration
public class ModelConfig {

    /**
     * Creates a new instance of ChatModel using the provided Anthropic3ChatBedrockApi and Anthropic3ChatOptions.
     *
     * @param api     the Anthropic3ChatBedrockApi instance to be used by the ChatModel
     * @param options the Anthropic3ChatOptions instance to configure the ChatModel
     * @return a new instance of ChatModel
     */
    @Bean
    public ChatModel chatModel(Anthropic3ChatBedrockApi api, Anthropic3ChatOptions options) {
        return new BedrockAnthropic3ChatModel(api, options);
    }

    /**
     * Creates an instance of Anthropic3ChatBedrockApi.
     *
     * @param awsRegion              the AWS region where the API will be executed
     * @param credentialsProvider    the credentials provider for authenticating API requests
     * @return an instance of Anthropic3ChatBedrockApi
     */
    @Bean
    public Anthropic3ChatBedrockApi anthropic3ChatBedrockApi(Region awsRegion, EnvironmentVariableCredentialsProvider credentialsProvider) {
        return new Anthropic3ChatBedrockApi(
                Anthropic3ChatBedrockApi.AnthropicChatModel.CLAUDE_V3_SONNET.id(),
                credentialsProvider,
                awsRegion.id(),
                new ObjectMapper(),
                Duration.ofMillis(3*60*1000L)
        );
    }

    /**
     * Returns a new instance of {@link Anthropic3ChatOptions} with default values.
     *
     * @return a new instance of {@link Anthropic3ChatOptions}
     */
    @Bean
    public Anthropic3ChatOptions anthropicChatOptions() {
        return Anthropic3ChatOptions.builder()
                .withTemperature(0.8f)
                .withTopK(10)
                .withTopP(0.8f)
                .withMaxTokens(4000)
                .withAnthropicVersion(AnthropicChatBedrockApi.DEFAULT_ANTHROPIC_VERSION)
                .build();
    }

    @Bean
    public ChatClient aiClient(ChatModel chatModel) {
        return ChatClient.builder(chatModel).build();
    }

    @Bean
    public QuestionAnswerAdvisor advisor(VectorStore vectorStore) {
        return new QuestionAnswerAdvisor(vectorStore, SearchRequest.defaults());
    }
}
