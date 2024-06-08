package ship.it.goodgolems.jpa.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ship.it.goodgolems.domain.ProjectRequirement;

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
