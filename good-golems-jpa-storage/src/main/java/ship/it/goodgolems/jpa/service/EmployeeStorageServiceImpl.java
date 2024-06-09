package ship.it.goodgolems.jpa.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.jpa.mapper.EmployeeMapper;
import ship.it.goodgolems.jpa.repository.EmployeeRepository;
import ship.it.goodgolems.spi.storage.EmployeeStorage;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeeStorageServiceImpl implements EmployeeStorage  {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper mapper;

    @Override
    public Set<Employee> getEmployees() {
        return employeeRepository.findAll().stream()
                .map(mapper::map)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Employee> getAvailableEmployees() {
        return employeeRepository.findAvailableEmployees();
    }
}
