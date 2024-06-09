package ship.it.goodgolems.anthropic.claude;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.spi.ai.model.AiClient;

/**
 * The AiFacade class is a facade that provides simplified methods for interacting with an AI chat client.
 * It implements the AiClient interface.
 */
@Component
@RequiredArgsConstructor
public class AiFacade implements AiClient {

    private final ChatClient aiClient;
    private final QuestionAnswerAdvisor advisor;

    /**
     * Retrieves a String representation of the AI chat client's response to a user prompt.
     *
     * @param prompt the user prompt for the AI chat client
     * @return a String representation of the AI chat client's response
     */
    public String getResponseAsString(String prompt) {
        return sendUserPrompt(prompt)
                .content();
    }

    /**
     * Retrieves a chat response from the AI chat client based on the given prompt.
     *
     * @param prompt the user prompt for the AI chat client
     * @return the chat response from the AI chat client
     */
    public ChatResponse getResponse(String prompt) {
        return sendUserPrompt(prompt)
                .chatResponse();
    }

    /**
     * Retrieves a response from the AI chat client based on the given prompt and response type.
     *
     * @param prompt the user prompt for the AI chat client
     * @param responseType the response type for the AI chat client's response
     * @param <T> the type of the response
     * @return the response from the AI chat client
     */
    public <T> T getResponse(String prompt, Class<T> responseType) {
        return sendUserPrompt(prompt)
                .entity(responseType);
    }

    /**
     * Retrieves a response from the AI chat client based on the given prompt and response type.
     *
     * @param prompt       the user prompt for the AI chat client
     * @param responseType the response type for the AI chat client's response
     * @param <T>          the type of the response
     * @return the response from the AI chat client
     */
    public <T> List<T> getResponse(String prompt, ParameterizedTypeReference<List<T>> responseType) {
        return sendUserPrompt(prompt)
                .entity(responseType);
    }

    /**
     * Retrieves a String representation of the AI chat client's response to a user prompt.
     *
     * @param prompt the user prompt for the AI chat client
     * @return a String representation of the AI chat client's response
     */
    @Override
    public String adviseResponseAsString(String prompt) {
        return sendAdviserPrompt(prompt)
                .content();
    }

    /**
     * Retrieves a response from the AI chat client based on the given prompt and response type.
     *
     * @param prompt       the user prompt for the AI chat client
     * @param responseType the response type for the AI chat client's response
     * @param <T>          the type of the response
     * @return the response from the AI chat client
     */
    @Override
    public <T> T adviseResponse(String prompt, Class<T> responseType) {
        return sendAdviserPrompt(prompt)
                .entity(responseType);
    }

    /**
     * Retrieves a response from the AI chat client based on the given prompt and response type.
     *
     * @param prompt       the user prompt for the AI chat client
     * @param responseType the response type for the AI chat client's response
     * @param <T>          the type of the response
     * @return the response from the AI chat client
     */
    @Override
    public <T> List<T> adviseResponse(String prompt, ParameterizedTypeReference<List<T>> responseType) {
        return sendAdviserPrompt(prompt)
                .entity(responseType);
    }

    private ChatClient.ChatClientRequest.CallResponseSpec sendUserPrompt(String prompt) {
        return aiClient.prompt()
                .user(prompt)
                .call();
    }

    private ChatClient.ChatClientRequest.CallResponseSpec sendAdviserPrompt(String prompt) {
        return aiClient.prompt()
                .advisors(advisor)
                .user(prompt)
                .call();
    }
}
