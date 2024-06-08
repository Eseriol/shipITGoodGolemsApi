package ship.it.goodgolems.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import ship.it.goodgolems.domain.ExperiencedCount;
import ship.it.goodgolems.jpa.model.ExperiencedCountEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExperiencedCountMapper {

    @Mapping(source = "yearsOfExperience", target = "yearsOfExperience")
    @Mapping(source = "countOfEmployee", target = "countOfEmployee")
    @Mapping(target = "id", ignore = true)
    ExperiencedCountEntity map(ExperiencedCount experiencedCount);
}
