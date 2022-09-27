package zpi.algospace.solution;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zpi.algospace.files.FileExecutor;
import zpi.algospace.process.ProgramBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProgramRunner {
    private final ProgramResultValidator programResultValidator;

    public Boolean runProgram(FileExecutor fileExecutor, long taskId) throws IOException, InterruptedException {
        new ProgramBuilder(fileExecutor.getInputFile(), fileExecutor.getErrorFile(), fileExecutor.getOutputFile()).run();

        return programResultValidator.validateResult(Files.readString(fileExecutor.getOutputFile().toPath(), StandardCharsets.UTF_8), taskId);
    }
}
