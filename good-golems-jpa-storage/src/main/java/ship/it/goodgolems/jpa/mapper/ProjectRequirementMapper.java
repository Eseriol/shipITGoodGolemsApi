package ship.it.goodgolems.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import ship.it.goodgolems.domain.ProjectRequirement;
import ship.it.goodgolems.jpa.model.ProjectRequirementEntity;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface ProjectRequirementMapper {
    @Mapping(source = "stack", target = "stack")
    @Mapping(source = "experiencedCount", target = "experiencedCount")
    @Mapping(target = "id", ignore = true)
    ProjectRequirementEntity map(ProjectRequirement projectRequirement);

    @Mapping(source = "stack", target = "stack")
    @Mapping(source = "experiencedCount", target = "experiencedCount")
    ProjectRequirement map(ProjectRequirementEntity projectRequirement);
}
