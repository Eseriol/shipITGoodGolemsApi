package ship.it.goodgolems.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.jpa.model.EmployeeEntity;

@Mapper
public interface EmployeeMapper {
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "position", target = "position")
    @Mapping(source = "experience", target = "experience")
    @Mapping(source = "currentProject", target = "currentProject")
    EmployeeEntity map(Employee employee);
}
