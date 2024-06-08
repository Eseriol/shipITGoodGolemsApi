package ship.it.goodgolems.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ship.it.goodgolems.domain.ExperiencedCount;
import ship.it.goodgolems.jpa.model.ExperiencedCountEntity;

@Mapper
public interface ExperiencedCountMapper {

    @Mapping(source = "yearsOfExperience", target = "yearsOfExperience")
    @Mapping(source = "countOfEmployee", target = "countOfEmployee")
    ExperiencedCountEntity map(ExperiencedCount experiencedCount);
}
