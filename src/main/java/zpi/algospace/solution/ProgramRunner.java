package zpi.algospace.solution;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zpi.algospace.process.ProgramBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProgramRunner {
    private final ProgramResultValidator programResultValidator;

    public Boolean runProgram(File inputFile, File errorFile, File outputFile, long taskId) throws IOException, InterruptedException {
        ProgramBuilder builder = new ProgramBuilder(inputFile, errorFile, outputFile);
        builder.run();

        return programResultValidator.validateResult(Files.readString(outputFile.toPath(), StandardCharsets.UTF_8), taskId);
    }
}
