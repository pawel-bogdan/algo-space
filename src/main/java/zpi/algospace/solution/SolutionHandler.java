package zpi.algospace.solution;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zpi.algospace.files.CppExecutor;
import zpi.algospace.files.FileExecutor;
import zpi.algospace.files.JavaExecutor;
import zpi.algospace.files.PythonExecutor;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class SolutionHandler {
    private final ProgramRunner programRunner;

    public Boolean handle(Solution solution, String fileName) throws IOException, InterruptedException {
        FileExecutor fileExecutor = createFileExecutor(solution.getLanguage(), fileName, solution.getComplementedContent());
        try {
            return programRunner.runProgram(fileExecutor, solution.getTask().getId());
        } finally {
            Cleaner.cleanDirectory(fileExecutor.getFilePathsToDelete());
        }
    }

    private FileExecutor createFileExecutor(Language language, String fileName, String complementedSolution) {
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
