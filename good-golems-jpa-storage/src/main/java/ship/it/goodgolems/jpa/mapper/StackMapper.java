package ship.it.goodgolems.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import ship.it.goodgolems.domain.Stack;
import ship.it.goodgolems.jpa.model.StackEntity;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface StackMapper {
    @Mapping(source = "technologyName", target = "technologyName")
    @Mapping(target = "id", ignore = true)
    StackEntity map(Stack stack);

    @Mapping(source = "technologyName", target = "technologyName")
    Stack map(StackEntity stack);
}
