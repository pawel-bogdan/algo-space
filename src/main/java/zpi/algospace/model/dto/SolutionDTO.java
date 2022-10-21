package zpi.algospace.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import zpi.algospace.model.Language;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SolutionDTO {
    private LocalDateTime submitionDate;
    private String content;
    private Language language;
    private Long taskId;
    private String solverEmail;
}

