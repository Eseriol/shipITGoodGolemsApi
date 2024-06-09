package ship.it.goodgolems.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import ship.it.goodgolems.jpa.model.StackEntity;

public interface StackRepository extends CrudRepository<StackEntity, Long> {
}
