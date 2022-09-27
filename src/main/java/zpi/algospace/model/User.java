package zpi.algospace.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "USERR")
public class User {
    @Id
    private String email;
    private Integer points;
    @OneToMany(mappedBy = "solver")
    private List<Solution> solutions;

}
