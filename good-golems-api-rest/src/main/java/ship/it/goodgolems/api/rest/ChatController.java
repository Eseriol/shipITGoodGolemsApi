package ship.it.goodgolems.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.SimpleChatApi;

/**
 * The ChatController class is a REST controller that handles HTTP requests related to chat functionality.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/chat", produces = "text/plain")
public class ChatController {

    private final SimpleChatApi chatApi;

    /**
     * Retrieves the response generated by the chatApi based on a predefined prompt.
     *
     * @return The response generated by the chatApi.
     */
    @GetMapping("/test")
    public String getResponse() {
        return chatApi.getResponse("What is the latest Java version?");
    }

    /**
     * Retrieves the response generated by the chatApi based on the specified prompt.
     *
     * @param prompt The prompt to be displayed.
     * @return The response generated by the chatApi based on the provided prompt.
     */
    @PostMapping("/test")
    public String getResponse(@RequestBody String prompt) {
        return chatApi.getResponse(prompt);
    }
}
