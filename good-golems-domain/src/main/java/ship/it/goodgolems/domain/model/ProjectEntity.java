package ship.it.goodgolems.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ship.it.goodgolems.domain.ProjectRequirement;

import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    String name;

    @OneToMany
    Set<EmployeeEntity> employees;

    @OneToMany
    Set<ProjectRequirement> requirements;
}
