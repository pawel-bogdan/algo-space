package zpi.algospace.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import zpi.algospace.model.dto.TaskGeneralInfo;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private String expectedOutput;
    @OneToMany
    @JoinColumn(name = "taskId")
    private List<Test> tests;
    private Category category;
    private Difficulty difficulty;
    @OneToMany
    @JoinColumn(name = "taskId")
    private List<Hint> hints;
    private String template;
    @ElementCollection(targetClass = Language.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private List<Language> availableLanguages;
    @OneToMany(mappedBy = "task")
    private List<Solution> solutions;

    public TaskGeneralInfo toTaskGeneralInfo() {
        return TaskGeneralInfo.builder()
                .id(this.id)
                .name(this.name)
                .category(this.category)
                .difficulty(this.difficulty)
                .build();
    }
}