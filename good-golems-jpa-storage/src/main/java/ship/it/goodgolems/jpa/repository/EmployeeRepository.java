package ship.it.goodgolems.jpa.repository;

import java.util.Set;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.jpa.model.EmployeeEntity;

@Repository
public interface EmployeeRepository extends ListCrudRepository<EmployeeEntity, Long> {

    default Set<Employee> findAvailableEmployees() {
        return findEmployeesByCurrentProjectEmpty(
                Employee.class
        );
    }

    <T> Set<T> findEmployeesByCurrentProjectEmpty(Class<T> type);
}
