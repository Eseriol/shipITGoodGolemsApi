package ship.it.goodgolems.anthropic.claude;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.spi.ai.model.AiClient;

@Component
@RequiredArgsConstructor
public class AiFacade implements AiClient {

    private final ChatClient aiClient;

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

    private ChatClient.ChatClientRequest.CallResponseSpec sendUserPrompt(String prompt) {
        return aiClient.prompt()
                .user(prompt)
                .call();
    }
}
