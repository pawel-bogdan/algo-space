package zpi.algospace.solution;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zpi.algospace.model.Solution;

import java.io.IOException;

@Service
@Getter
@Slf4j
@RequiredArgsConstructor
public class SolutionService {
    private final SolutionComplementer solutionComplementer;
    private final SolutionHandler solutionHandler;

    public Boolean judgeSolution(Solution solution) throws IOException, InterruptedException {
        String fileName = SolutionNamesCreator.createFileName(solution);
        String complementedSolution = solutionComplementer.complement(solution, fileName);

        return solutionHandler.handle(solution.getLanguage(), fileName, complementedSolution, solution.getTaskId());
    }
}
