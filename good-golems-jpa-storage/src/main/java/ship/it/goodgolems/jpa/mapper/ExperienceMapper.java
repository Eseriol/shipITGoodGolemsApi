package ship.it.goodgolems.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ship.it.goodgolems.domain.Experience;
import ship.it.goodgolems.jpa.model.ExperienceEntity;

@Mapper
public interface ExperienceMapper {

    @Mapping(source = "stack", target = "stack")
    @Mapping(source = "years", target = "years")
    ExperienceEntity map(Experience experience);
}
