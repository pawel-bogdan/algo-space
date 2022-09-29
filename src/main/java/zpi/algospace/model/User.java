package zpi.algospace.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "ApplicationUsers")
public class User {
    @Id
    private String email;
    private Integer points;
    @OneToMany(mappedBy = "solver")
    private List<Solution> solutions;
}
