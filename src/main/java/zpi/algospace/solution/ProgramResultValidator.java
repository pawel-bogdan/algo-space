package zpi.algospace.solution;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zpi.algospace.files.config.ProgramConfig;
import zpi.algospace.model.Task;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;

@Slf4j
@Component
public class ProgramResultValidator {

    public static Boolean validateResult(ProgramConfig programConfig, Task task) throws IOException {
        String solutionOutput = Files.readString(programConfig.getOutputFile().toPath(), StandardCharsets.UTF_8);
        String expectedOutput = task.getExpectedOutput();
        log.info("Actual output: {}", solutionOutput);
        log.info("Expected output: {}", expectedOutput);

        return Objects.equals(solutionOutput.trim(), expectedOutput.trim());
    }
}
