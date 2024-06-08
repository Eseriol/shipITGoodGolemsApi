package ship.it.goodgolems.spi.ai.model;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;

public interface AiClient {

    String getResponseAsString(String prompt);

    <T> T getResponse(String prompt, Class<T> responseType);

    <T> List<T> getResponse(String prompt, ParameterizedTypeReference<List<T>> responseType);

}