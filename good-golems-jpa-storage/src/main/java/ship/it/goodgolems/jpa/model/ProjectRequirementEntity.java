package ship.it.goodgolems.jpa.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "ProjectRequirement")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProjectRequirementEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stack_id")
    private StackEntity stack;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ExperiencedCountEntity> experiencedCount;
}
