package ship.it.goodgolems.spi.vectordb;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.ai.VectorStoreDocument;

public interface VectorStoregeService {

    List<String> simpleVector(String query);

    List<VectorStoreDocument> store(Collection<Employee> employees);

    Optional<Boolean> delete(List<String> documentIds);

}
