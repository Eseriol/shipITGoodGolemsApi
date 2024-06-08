package ship.it.goodgolems.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import ship.it.goodgolems.domain.Stack;

public interface StackRepository extends CrudRepository<Stack, Long> {
}
