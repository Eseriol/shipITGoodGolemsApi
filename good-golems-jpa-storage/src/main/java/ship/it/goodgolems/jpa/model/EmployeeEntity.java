package ship.it.goodgolems.jpa.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
