package ship.it.goodgolems.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.SimpleChatApi;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/chat", produces = "text/plain")
public class ChatController {

    private final SimpleChatApi chatApi;

    @GetMapping("/test")
    public String getResponse() {
        return chatApi.getResponse("What is the latest Java version?");
    }

    @PostMapping("/test")
    public String getResponse(@RequestBody String prompt) {
        return chatApi.getResponse(prompt);
    }
}
