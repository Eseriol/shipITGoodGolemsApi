package ship.it.goodgolems.spi.vectordb;

import java.util.List;

public interface VectorStoregeService {

    List<String> simpleVector(String query);

}
