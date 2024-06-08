package ship.it.goodgolems.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.domain.model.ProjectEntity;

@Mapper
public interface ProjectMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "employees", target = "employees")
    @Mapping(source = "requirements", target = "requirements")
    ProjectEntity map(Project project);
}
