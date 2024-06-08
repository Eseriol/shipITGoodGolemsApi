package ship.it.goodgolems.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.jpa.repository.EmployeeRepository;
import ship.it.goodgolems.spi.storage.EmployeeStorage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EmployeeStorageServiceImpl implements EmployeeStorage  {

    @Autowired
    private  EmployeeRepository employeeRepository;

    @Override
    public Set<Employee> getEmployees() {
        Iterator<Employee> iterator = employeeRepository.findAll().iterator();
        Set<Employee> result = new HashSet<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }

    @Override
    public Set<Employee> getAvailableEmployees() {

        return Set.of();
    }
}
