package ship.it.goodgolems.domain.mapper;

import org.mapstruct.Mapper;
import ship.it.goodgolems.domain.ProjectRequirement;
import ship.it.goodgolems.domain.model.ProjectRequirementEntity;

@Mapper
public interface ProjectRequirementMapper {
    ProjectRequirementEntity map(ProjectRequirement projectRequirement);
}
