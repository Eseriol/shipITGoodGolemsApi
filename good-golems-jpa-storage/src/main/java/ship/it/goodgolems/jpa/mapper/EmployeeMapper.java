package ship.it.goodgolems.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.jpa.model.EmployeeEntity;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface EmployeeMapper {
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "position", target = "position")
    @Mapping(source = "experience", target = "experience")
    @Mapping(source = "currentProject", target = "currentProject")
    @Mapping(target = "id", ignore = true)
    EmployeeEntity map(Employee employee);

    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "position", target = "position")
    @Mapping(source = "experience", target = "experience")
    @Mapping(source = "currentProject", target = "currentProject")
    Employee map(EmployeeEntity employee);
}
