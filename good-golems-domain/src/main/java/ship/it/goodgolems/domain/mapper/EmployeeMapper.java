package ship.it.goodgolems.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.model.EmployeeEntity;

@Mapper
public interface EmployeeMapper {
    EmployeeEntity map(Employee employee);
}
