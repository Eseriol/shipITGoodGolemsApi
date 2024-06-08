package ship.it.goodgolems.domain.mapper;

import org.mapstruct.Mapper;
import ship.it.goodgolems.domain.Experience;
import ship.it.goodgolems.domain.model.ExperienceEntity;

@Mapper
public interface ExperienceMapper {
    ExperienceEntity map(Experience experience);
}
