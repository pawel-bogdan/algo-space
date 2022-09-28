package zpi.algospace.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.repository.TaskRepository;
import zpi.algospace.repository.UserRepository;

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

    public Solution toSolution(TaskRepository taskRepository, UserRepository userRepository) {
        Solution solution = new Solution();
        solution.setSubmitionDate(submitionDate);
        solution.setContent(content);
        solution.setLanguage(language);
        solution.setTask(taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Requested task doesn't exist")));
        solution.setSolver(userRepository.findFirstByEmail(solverEmail)
                .orElseThrow(() -> new IllegalArgumentException("Requested user doesn't exist")));

        return solution;
    }
}
