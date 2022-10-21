package zpi.algospace.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@AllArgsConstructor
@Builder
@Table(name = "ApplicationUsers")
public class User {
    @Id
    private String email;
    private Integer points;
    @OneToMany(mappedBy = "solver")
    private List<Solution> solutions;
}
