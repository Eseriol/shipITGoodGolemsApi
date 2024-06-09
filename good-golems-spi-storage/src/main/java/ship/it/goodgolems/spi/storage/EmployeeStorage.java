package ship.it.goodgolems.spi.storage;

import java.util.Set;

import ship.it.goodgolems.domain.Employee;

/**
 * The EmployeeStorage interface provides methods to retrieve information about employees.
 */
public interface EmployeeStorage {

    /**
     * Get all employees from DB
     * @return
     */
    Set<Employee> getEmployees();

    /**
     * Get employees who are not assigned to any projects
     * @return
     */
    Set<Employee> getAvailableEmployees();

}
