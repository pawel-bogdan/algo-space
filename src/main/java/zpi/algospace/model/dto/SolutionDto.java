package zpi.algospace.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class SolutionDto {
    private final LocalDateTime submissionDate;
    private final String content;
    private final Language language;
    private final Long taskId;
    private final String solverUsername;

    public SolutionDto(Solution solution) {
        submissionDate = solution.getSubmissionDate();
        content = solution.getContent();
        language = solution.getLanguage();
        taskId = solution.getTask().getId();
        solverUsername = solution.getSolver().getUsername();
    }
}
