package zpi.algospace.solution;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zpi.algospace.files.FileExecutor;
import zpi.algospace.files.FilesHandler;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Task;
import zpi.algospace.process.ProgramBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;
import java.util.UUID;


@Service
@Getter
@Slf4j
@RequiredArgsConstructor
public class SolutionsService {

    private final SolutionHandler solutionHandler;
    private final FilesHandler filesHandler;

    public Boolean judgeFunction(long taskId, String language, int userId, String sourceCode) throws IOException, InterruptedException {
        Solution solution = new Solution(sourceCode, language, taskId, userId);
        String fileName = solution.getLanguage().getLanguageName() + String.valueOf(UUID.randomUUID()).replace("-", "");
        String complementedSolution = solutionHandler.handle(solution, fileName);

        FileExecutor fileExecutor = filesHandler.handle(solution.getLanguage(), fileName, complementedSolution);

        ProgramBuilder builder = new ProgramBuilder(fileExecutor.getInputFile(), fileExecutor.getErrorFile(), fileExecutor.getOutputFile());
        builder.run();

        String output = Files.readString(fileExecutor.getOutputFile().toPath(),
                StandardCharsets.UTF_8);
        log.info("received output: " + output);


        Cleaner.cleanDirectory(fileExecutor.getFilePathsToDelete());
        //testowo
        return compareResult(output, new Task(1));
    }

    private Boolean compareResult(String output, Task task) {
        //cos takiego return output == task.getExpectedOutput();
        return Objects.equals(output.trim(), "hello");
    }
}
