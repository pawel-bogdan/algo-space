package zpi.algospace.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import zpi.algospace.model.dto.TaskGeneralInfo;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private Category category;
    private Difficulty difficulty;
    @OneToMany
    @JoinColumn(name = "taskId")
    private List<Hint> hints;

    public TaskGeneralInfo toTaskGeneralInfo() {
        return TaskGeneralInfo.builder()
                .id(this.id)
                .name(this.name)
                .category(this.category)
                .difficulty(this.difficulty)
                .build();
    }

}