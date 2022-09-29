package zpi.algospace.model.dto;

import lombok.Getter;
import zpi.algospace.model.Category;
import zpi.algospace.model.Difficulty;
import zpi.algospace.model.Language;
import zpi.algospace.model.Task;

import java.util.List;
import java.util.stream.Collectors;

@Getter // Jackson
public class TaskDTO {
    private final Long id;
    private final String name;
    private final String content;
    private final Category category;
    private final Difficulty difficulty;
    private final List<HintDTO> hints;
    private final List<Language> availableLanguages;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.content = task.getContent();
        this.category = task.getCategory();
        this.difficulty = task.getDifficulty();
        this.hints = task.getHints().stream().map(HintDTO::new).collect(Collectors.toList());
        this.availableLanguages = task.getAvailableLanguages();
    }
}
