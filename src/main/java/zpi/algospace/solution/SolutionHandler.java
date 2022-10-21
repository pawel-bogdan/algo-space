package zpi.algospace.solution;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zpi.algospace.files.*;
import zpi.algospace.files.config.CppProgramConfig;
import zpi.algospace.files.config.JavaProgramConfig;
import zpi.algospace.files.config.ProgramConfig;
import zpi.algospace.files.config.PythonProgramConfig;
import zpi.algospace.model.Solution;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class SolutionHandler {
    private final ProgramRunner programRunner;
    private final ProgramResultValidator programResultValidator;

    public Boolean handle(Solution solution, String fileName) throws IOException, InterruptedException {
        ProgramConfig programConfig = createProgramConfig(solution, fileName);
        try {
            programRunner.run(programConfig);
            return programResultValidator.validateResult(programConfig, solution.getTask());
        } finally {
            Cleaner.cleanDirectory(programConfig.getFilePathsToDelete());
        }
    }

    private ProgramConfig createProgramConfig(Solution solution, String fileName) {
        final String complementedContent = solution.getComplementedContent();
        switch (solution.getLanguage()) {
            case JAVA:
                return new JavaProgramConfig(complementedContent, fileName);
            case CPP:
                return new CppProgramConfig(complementedContent, fileName);
            case PYTHON:
                return new PythonProgramConfig(complementedContent, fileName);
            default:
                log.error("The specified language is not yet supported.");
                throw new IllegalArgumentException();
        }
    }
}
