package zpi.algospace.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import zpi.algospace.model.dto.DifficultyDTO;
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
    private Long id;
    private String name;
    @Column(length = 2000)
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
    @OneToMany
    @JoinColumn(name = "taskId")
    private List<Template> template;
    @ElementCollection(targetClass = Language.class)
    @CollectionTable
    @Enumerated(EnumType.ORDINAL)
    private List<Language> availableLanguages;
    @OneToMany(mappedBy = "task")
    private List<Solution> solutions;

    public TaskGeneralInfo toTaskGeneralInfo() {
        return TaskGeneralInfo.builder()
                .id(this.id)
                .name(this.name)
                .category(this.category)
                .difficulty(new DifficultyDTO(this.difficulty))
                .build();
    }
}