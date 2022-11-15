package zpi.algospace.model.dto;

import lombok.Builder;
import lombok.Data;
import zpi.algospace.model.Language;

import java.time.LocalDateTime;


@Data
@Builder
public class SolutionDTO {
    private final LocalDateTime submissionDate;
    private final String content;
    private final Language language;
    private final Long taskId;
    private final String solverUsername;
}
