package zpi.algospace;

import lombok.Data;
import zpi.algospace.models.Difficulty;
import zpi.algospace.models.dto.TaskGeneralInfo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private Category category;
    private Difficulty difficulty;

    public Task() {

    }

    public TaskGeneralInfo toTaskGeneralInfo() {
        return TaskGeneralInfo.builder()
                .id(this.id)
                .name(this.name)
                .category(this.category)
                .difficulty(this.difficulty)
                .build();
    }
    //private List<Hint> hints;
}
