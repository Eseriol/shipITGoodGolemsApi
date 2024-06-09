package ship.it.goodgolems.core;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.VectorApi;
import ship.it.goodgolems.spi.vectordb.VectorStoregeService;

/**
 * The VectorService class implements the VectorApi interface and provides methods for generating vector-based search queries.
 */
@RequiredArgsConstructor
public class VectorService implements VectorApi {

    private final VectorStoregeService vectorStoregeService;

    /**
     * Generates a vector-based search query using the specified query string.
     *
     * @param query the query string to be used for generating the search query
     * @return the generated vector-based search query
     */
    @Override
    public String genVectorSearch(String query) {
        return vectorStoregeService.simpleVector(query).get(0);
    }
}
