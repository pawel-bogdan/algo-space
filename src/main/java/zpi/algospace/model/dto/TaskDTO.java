package zpi.algospace.model.dto;

import lombok.Getter;
import zpi.algospace.model.Category;
import zpi.algospace.model.Difficulty;
import zpi.algospace.model.Task;

import java.util.List;
import java.util.stream.Collectors;

@Getter // Jackson
public class TaskDTO {
    private Long id;
    private String name;
    private String content;
    private Category category;
    private Difficulty difficulty;
    private List<HintDTO> hints;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.content = task.getContent();
        this.category = task.getCategory();
        this.difficulty = task.getDifficulty();
        this.hints = task.getHints().stream().map(HintDTO::new).collect(Collectors.toList());
    }
}
