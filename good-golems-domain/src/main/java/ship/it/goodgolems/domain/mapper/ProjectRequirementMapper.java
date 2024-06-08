package ship.it.goodgolems.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ship.it.goodgolems.domain.ProjectRequirement;
import ship.it.goodgolems.domain.model.ProjectRequirementEntity;

@Mapper
public interface ProjectRequirementMapper {
    @Mapping(source = "stack", target = "stack")
    @Mapping(source = "experiencedCount", target = "experiencedCount")
    ProjectRequirementEntity map(ProjectRequirement projectRequirement);
}
