package zpi.algospace.solution;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zpi.algospace.files.FileExecutor;
import zpi.algospace.files.SolutionHandler;
import zpi.algospace.model.Solution;
import zpi.algospace.process.ProgramBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;


@Service
@Getter
@Slf4j
@RequiredArgsConstructor
public class SolutionService {

    private final SolutionComplementer solutionComplementer;
    private final SolutionHandler solutionHandler;

    public Boolean judgeSolution(Solution solution) throws IOException, InterruptedException {

        String complementedSolution = solutionComplementer.complement(solution);

        FileExecutor fileExecutor = solutionComplementer.complement(solution.getLanguage(), fileName, complementedSolution);

        ProgramBuilder builder = new ProgramBuilder(fileExecutor.getInputFile(), fileExecutor.getErrorFile(), fileExecutor.getOutputFile());
        builder.run();

        String output = Files.readString(fileExecutor.getOutputFile().toPath(),
                StandardCharsets.UTF_8);
        log.info("received output: " + output);


        Cleaner.cleanDirectory(fileExecutor.getFilePathsToDelete());
        //testowo
        return compareResult(output);
    }

    private Boolean compareResult(String output) {
        //cos takiego return output == task.getExpectedOutput();
        return Objects.equals(output.trim(), "hello");
    }
}
