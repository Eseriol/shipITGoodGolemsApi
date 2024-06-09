package ship.it.goodgolems.jpa.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.jpa.mapper.EmployeeMapper;
import ship.it.goodgolems.jpa.model.EmployeeEntity;
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
        return employeeRepository.findAll().stream().map(mapper::map).filter(Employee::isAvailable).collect(Collectors.toSet());
    }

    public List<EmployeeEntity> getEmployeesByTechnology(String technologyName) {
        return employeeRepository.findAllByTechnologyName(technologyName);
    }

    public List<EmployeeEntity> getEmployeesByPosition(String position) {
        return employeeRepository.findAllByPosition(position);
    }

    public List<EmployeeEntity> getEmployeesByProjectName(String projectName) {
        return employeeRepository.findAllByProjectName(projectName);
    }

    public List<EmployeeEntity> getEmployeesByTechnologyAndMinYears(String technologyName, int years) {
        return employeeRepository.findAllByTechnologyAndMinYears(technologyName, years);
    }

    public List<EmployeeEntity> getEmployeesByProjectId(Long projectId) {
        return employeeRepository.findAllByProjectId(projectId);
    }

    public List<EmployeeEntity> getEmployeesByFullName(String fullName) {
        return employeeRepository.findAllByFullName(fullName);
    }

    public List<EmployeeEntity> getEmployeesByTechnologyNames(List<String> technologyNames) {
        return employeeRepository.findAllByTechnologyNames(technologyNames);
    }

    public List<EmployeeEntity> getEmployeesByProjectRequirement(String technologyName) {
        return employeeRepository.findAllByProjectRequirement(technologyName);
    }

    public List<EmployeeEntity> getEmployeesBySeniorityLevel(String seniorityLevel) {
        return employeeRepository.findAllBySeniorityLevel(seniorityLevel);
    }

    public List<EmployeeEntity> getEmployeesByStackAndMinYears(String technologyName, int years) {
        return employeeRepository.findAllByStackAndMinYears(technologyName, years);
    }

    public List<EmployeeEntity> getEmployeesByNumberOfProjectsGreaterThan(int numberOfProjects) {
        return employeeRepository.findAllByNumberOfProjectsGreaterThan(numberOfProjects);
    }


}
