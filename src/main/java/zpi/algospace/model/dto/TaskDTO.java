package zpi.algospace.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import zpi.algospace.model.Category;
import zpi.algospace.model.Hint;
import zpi.algospace.model.Language;
import zpi.algospace.model.Template;
import zpi.algospace.model.Task;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
public class TaskDTO {
    private final Long id;
    private final String name;
    private final String content;
    private final Category category;
    private final DifficultyDTO difficulty;
    private final List<HintDTO> hints;
    private final List<Language> availableLanguages;
    private final List<Template> templates;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.content = task.getContent();
        this.category = task.getCategory();
        this.difficulty = new DifficultyDTO(task.getDifficulty());
        List<Hint> taskHints = task.getHints();
        if (taskHints != null)
            this.hints = task.getHints().stream().map(HintDTO::new).collect(Collectors.toList());
        else
            this.hints = null;
        this.availableLanguages = task.getAvailableLanguages();
        this.templates = task.getTemplate();
    }
}
