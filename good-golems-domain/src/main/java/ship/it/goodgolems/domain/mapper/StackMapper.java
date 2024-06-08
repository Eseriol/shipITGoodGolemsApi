package ship.it.goodgolems.domain.mapper;

import org.mapstruct.Mapper;
import ship.it.goodgolems.domain.Stack;
import ship.it.goodgolems.domain.model.StackEntity;

@Mapper
public interface StackMapper {
    StackEntity map(Stack stack);
}
