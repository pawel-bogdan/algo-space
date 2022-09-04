package zpi.algospace.model;

import lombok.Data;
import zpi.algospace.model.dto.TaskGeneralInfo;

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

    public Task(long taskId) {

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