package ship.it.goodgolems.core;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.api.VectorApi;
import ship.it.goodgolems.spi.vectordb.VectorStoregeService;

@RequiredArgsConstructor
public class VectorService implements VectorApi {

    private final VectorStoregeService vectorStoregeService;

    @Override
    public String genVectorSearch(String query) {
        return vectorStoregeService.simpleVector(query).get(0);
    }
}
