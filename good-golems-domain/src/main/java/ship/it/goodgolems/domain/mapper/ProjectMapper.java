package ship.it.goodgolems.domain.mapper;

import org.mapstruct.Mapper;
import ship.it.goodgolems.domain.Project;
import ship.it.goodgolems.domain.model.ProjectEntity;

@Mapper
public interface ProjectMapper {
    ProjectEntity map(Project project);
}
