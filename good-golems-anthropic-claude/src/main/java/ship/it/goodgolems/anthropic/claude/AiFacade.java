package ship.it.goodgolems.anthropic.claude;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.spi.ai.model.AiClient;

@Component
@RequiredArgsConstructor
public class AiFacade implements AiClient {

    private final ChatClient aiClient;
    private final QuestionAnswerAdvisor advisor;

    public String getResponseAsString(String prompt) {
        return sendUserPrompt(prompt)
                .content();
    }

    public ChatResponse getResponse(String prompt) {
        return sendUserPrompt(prompt)
                .chatResponse();
    }

    public <T> T getResponse(String prompt, Class<T> responseType) {
        return sendUserPrompt(prompt)
                .entity(responseType);
    }

    public <T> List<T> getResponse(String prompt, ParameterizedTypeReference<List<T>> responseType) {
        return sendUserPrompt(prompt)
                .entity(responseType);
    }

    @Override
    public String adviseResponseAsString(String prompt) {
        return sendAdviserPrompt(prompt)
                .content();
    }

    @Override
    public <T> T adviseResponse(String prompt, Class<T> responseType) {
        return sendAdviserPrompt(prompt)
                .entity(responseType);
    }

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
