package ship.it.goodgolems.core;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.SimpleChatApi;
import ship.it.goodgolems.spi.ai.model.AiClient;

@Service
@RequiredArgsConstructor
public class AiChatService implements SimpleChatApi {

    private final AiClient aiClient;

    public String getResponse(String prompt) {
        return aiClient.getResponseAsString(prompt);
    }
}
