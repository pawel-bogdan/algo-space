package zpi.algospace.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import zpi.algospace.model.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
@Builder
public class TaskDto {
    private final Long id;
    private final String name;
    private final String content;
    private final Category category;
    private final DifficultyDto difficulty;
    private final List<HintDto> hints;
    private final List<Language> availableLanguages;
    private final List<Template> templates;

    public TaskDto(Task task) {
        id = task.getId();
        name = task.getName();
        content = task.getContent();
        category = task.getCategory();
        difficulty = new DifficultyDto(task.getDifficulty());
        List<Hint> taskHints = task.getHints();
        if (taskHints != null)
            hints = task.getHints().stream().map(HintDto::new).collect(Collectors.toList());
        else
            hints = null;
        availableLanguages = task.getAvailableLanguages();
        templates = task.getTemplate();
    }
}
