package zpi.algospace.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zpi.algospace.model.Language;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class SolutionDTO {
    private LocalDateTime submitionDate;
    private String content;
    private Language language;
    private Long taskId;
    private String solverEmail;
}
