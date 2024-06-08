package ship.it.goodgolems.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ship.it.goodgolems.domain.Experience;
import ship.it.goodgolems.domain.model.ExperienceEntity;

@Mapper
public interface ExperienceMapper {

    @Mapping(source = "stack", target = "stack")
    @Mapping(source = "years", target = "years")
    ExperienceEntity map(Experience experience);
}
