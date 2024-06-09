package ship.it.goodgolems.jpa.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Project")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProjectEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    String name;

    @OneToMany(mappedBy = "currentProject")
    private Set<EmployeeEntity> employees;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Set<ProjectRequirementEntity> requirements;
}
