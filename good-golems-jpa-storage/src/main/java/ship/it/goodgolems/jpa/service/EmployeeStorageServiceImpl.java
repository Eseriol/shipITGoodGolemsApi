package ship.it.goodgolems.jpa.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.jpa.repository.EmployeeRepository;
import ship.it.goodgolems.spi.storage.EmployeeStorage;

@Service
@Transactional(readOnly = true)
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

        return new HashSet<>(employeeRepository.findEmployeesByAvailableIs(true));
    }
}
