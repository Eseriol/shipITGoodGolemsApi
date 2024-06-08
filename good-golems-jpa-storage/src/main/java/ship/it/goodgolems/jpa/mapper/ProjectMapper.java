package ship.it.goodgolems.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.jpa.model.ProjectEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "employees", target = "employees")
    @Mapping(source = "requirements", target = "requirements")
    @Mapping(target = "id", ignore = true)
    ProjectEntity map(Project project);
}
