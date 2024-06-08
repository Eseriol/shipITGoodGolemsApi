package ship.it.goodgolems.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "Employee")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String fullName;

    @Column
    private String position;

    @OneToMany
    private Set<ExperienceEntity> experience;

    @ManyToOne
    private ProjectEntity currentProject;
}
