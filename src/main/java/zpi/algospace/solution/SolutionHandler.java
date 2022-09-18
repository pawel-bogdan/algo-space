package zpi.algospace.solution;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zpi.algospace.files.CppExecutor;
import zpi.algospace.files.FileExecutor;
import zpi.algospace.files.JavaExecutor;
import zpi.algospace.files.PythonExecutor;
import zpi.algospace.model.Language;

@Slf4j
@Component
@RequiredArgsConstructor
public class SolutionHandler {
    private final ProgramRunner programRunner;

    @SneakyThrows
    public Boolean handle(Language language, String fileName, String complementedSolution, long taskId) {
        FileExecutor fileExecutor = chooseFileExecutor(language, fileName, complementedSolution);

        try {
            return programRunner.runProgram(fileExecutor.getInputFile(), fileExecutor.getErrorFile(), fileExecutor.getOutputFile(), taskId);
        } finally {
            Cleaner.cleanDirectory(fileExecutor.getFilePathsToDelete());
        }
    }

    @SneakyThrows
    public FileExecutor chooseFileExecutor(Language language, String fileName, String complementedSolution) {
        switch (language) {
            case JAVA:
                return new JavaExecutor(complementedSolution, fileName);
            case CPP:
                return new CppExecutor(complementedSolution, fileName);
            case PYTHON:
                return new PythonExecutor(complementedSolution, fileName);
            default:
                log.error("The specified language is not yet supported.");
                throw new IllegalArgumentException();
        }
    }
}
