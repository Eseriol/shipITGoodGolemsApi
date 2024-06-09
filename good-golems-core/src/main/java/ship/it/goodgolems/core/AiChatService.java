package ship.it.goodgolems.core;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.SimpleChatApi;
import ship.it.goodgolems.spi.ai.model.AiClient;

/**
 * AiChatService is a service class that implements the SimpleChatApi interface. It provides a method to get a response in a chat application by utilizing an AiClient instance.
 *
 * This class is annotated with @Service, indicating it as a Spring service component.
 *
 * @see SimpleChatApi
 * @see AiClient
 */
@Service
@RequiredArgsConstructor
public class AiChatService implements SimpleChatApi {

    private final AiClient aiClient;

    /**
     * Retrieves a response based on the given prompt.
     *
     * @param prompt The prompt to be displayed.
     * @return The response generated based on the prompt.
     */
    public String getResponse(String prompt) {
        return aiClient.getResponseAsString(prompt);
    }
}
