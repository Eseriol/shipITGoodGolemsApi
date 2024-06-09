package ship.it.goodgolems.api;

/**
 * SimpleChatApi is an interface that defines a method for getting a response in a chat application.
 */
public interface SimpleChatApi {

    /**
     * Retrieves a response based on the given prompt.
     *
     * @param prompt The prompt to be displayed.
     * @return The response generated based on the prompt.
     */
    String getResponse(String prompt);

}
