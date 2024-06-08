package ship.it.goodgolems.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ship.it.goodgolems.domain.Stack;
import ship.it.goodgolems.jpa.model.StackEntity;

@Mapper
public interface StackMapper {
    @Mapping(source = "technologyName", target = "technologyName")
    StackEntity map(Stack stack);
}
