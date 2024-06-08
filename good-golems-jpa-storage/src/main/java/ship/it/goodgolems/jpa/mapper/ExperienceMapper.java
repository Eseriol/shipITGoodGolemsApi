package ship.it.goodgolems.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import ship.it.goodgolems.domain.Experience;
import ship.it.goodgolems.jpa.model.ExperienceEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExperienceMapper {

    @Mapping(source = "stack", target = "stack")
    @Mapping(source = "years", target = "years")
    @Mapping(target = "id", ignore = true)
    ExperienceEntity map(Experience experience);
}
