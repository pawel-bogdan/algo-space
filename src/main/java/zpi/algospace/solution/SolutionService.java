package zpi.algospace.solution;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zpi.algospace.model.Solution;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class SolutionService {
    private final SolutionComplementer solutionComplementer;
    private final SolutionHandler solutionHandler;
    private static final boolean INVALID_SOLUTION = false;

    public Boolean judgeSolution(Solution solution) throws IOException, InterruptedException {
        String fileName = FileNameCreator.createFileName(solution);
        try {
            solutionComplementer.complement(solution, fileName);
        } catch (IllegalArgumentException e) {
            return INVALID_SOLUTION; // pozniej sie zrobi specjalna klase na feedback / wynik
        }
        return solutionHandler.handle(solution, fileName);
    }
}
