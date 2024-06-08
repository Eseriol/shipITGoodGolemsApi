package ship.it.goodgolems.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProjectRequirementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    StackEntity stack;

    @OneToMany
    Set<ExperiencedCountEntity> experiencedCount;
}
