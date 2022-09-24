package zpi.algospace.solution;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zpi.algospace.model.Task;
import zpi.algospace.repository.TaskRepository;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class ProgramResultValidator {
    final TaskRepository taskRepository;

    public Boolean validateResult(String readString, long taskId) {
        String expectedOutput = "";
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isPresent())
            expectedOutput = task.get().getExpectedOutput();

        log.info("Received output: {}", readString);
        log.info("Expected output: {}", expectedOutput);
        return Objects.equals(readString.trim(), expectedOutput.trim());
    }
}
