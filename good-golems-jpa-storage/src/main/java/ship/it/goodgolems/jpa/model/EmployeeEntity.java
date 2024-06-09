package ship.it.goodgolems.jpa.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Employee")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String fullName;

    @Column
    private String position;

    @OneToMany(cascade =  CascadeType.ALL, orphanRemoval = true)
    private Set<ExperienceEntity> experience;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "project_id")
    private ProjectEntity currentProject;
}
