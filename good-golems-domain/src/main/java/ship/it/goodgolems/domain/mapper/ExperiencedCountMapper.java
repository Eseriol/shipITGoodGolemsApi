package ship.it.goodgolems.domain.mapper;

import org.mapstruct.Mapper;
import ship.it.goodgolems.domain.ExperiencedCount;
import ship.it.goodgolems.domain.model.ExperiencedCountEntity;

@Mapper
public interface ExperiencedCountMapper {
    ExperiencedCountEntity map(ExperiencedCount experiencedCount);
}
