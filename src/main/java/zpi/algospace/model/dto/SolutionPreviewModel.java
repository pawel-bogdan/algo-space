package zpi.algospace.model.dto;

import lombok.Data;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Task;

import java.time.LocalDateTime;

@Data
public class SolutionPreviewModel {
    private final TaskGeneralInfo taskGeneralInfo;
    private final LanguageDto language;
    private final LocalDateTime submissionDate;
    private final String content;
    private final String solverUsername;

    public SolutionPreviewModel(Solution solution) {
        Task task = solution.getTask();
        taskGeneralInfo = TaskGeneralInfo.builder()
                .id(solution.getId())
                .name(task.getName())
                .category(new CategoryDto(task.getCategory()))
                .difficulty(new DifficultyDto(task.getDifficulty()))
                .build();
        language = new LanguageDto(solution.getLanguage());
        submissionDate = solution.getSubmissionDate();
        content = solution.getContent();
        solverUsername = solution.getSolver().getUsername();
    }
}
