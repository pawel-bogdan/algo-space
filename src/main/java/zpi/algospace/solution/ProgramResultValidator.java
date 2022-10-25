package zpi.algospace.solution;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zpi.algospace.files.config.ProgramConfig;
import zpi.algospace.model.Task;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;

@Component
@Slf4j
public class ProgramResultValidator {
    @SneakyThrows
    public static Boolean validateResult(ProgramConfig programConfig, Task task) {
        String solutionOutput = Files.readString(programConfig.getOutputFile().toPath(), StandardCharsets.UTF_8);
        String expectedOutput = task.getExpectedOutput();
        log.debug("Actual output: {}", solutionOutput);
        log.debug("Expected output: {}", expectedOutput);

        return Objects.equals(solutionOutput.trim(), expectedOutput.trim());
    }
}
