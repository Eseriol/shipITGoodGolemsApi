package ship.it.goodgolems.jpa.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Experience")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ExperienceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private StackEntity stack;

    @Column
    int years;
}
