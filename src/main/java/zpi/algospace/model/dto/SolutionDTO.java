package zpi.algospace.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Task;
import zpi.algospace.model.User;

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

    public Solution toSolution() {
        return new Solution(101L, LocalDateTime.now(), "cont", "onttasda", Language.JAVA, new Task(), new User());
    }
}
