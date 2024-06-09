package ship.it.goodgolems.api;

/**
 * The VectorApi interface provides methods for generating vector-based search queries.
 */
public interface VectorApi {

    /**
     * Generates a vector-based search query using the specified query string.
     *
     * @param query the query string to be used for generating the search query
     * @return the generated vector-based search query
     */
    String genVectorSearch(String query);

}
