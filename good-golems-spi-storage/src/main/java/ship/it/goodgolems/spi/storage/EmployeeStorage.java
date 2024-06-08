package ship.it.goodgolems.spi.storage;

import java.util.Set;

import ship.it.goodgolems.domain.Employee;

public interface EmployeeStorage {

    Set<Employee> getEmployees();

}
