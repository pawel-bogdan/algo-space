package zpi.algospace.solution;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zpi.algospace.complementer.Complementary;
import zpi.algospace.complementer.CppComplementer;
import zpi.algospace.complementer.JavaComplementer;
import zpi.algospace.complementer.PythonComplementer;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.repository.TaskRepository;

@Slf4j
@RequiredArgsConstructor
@Component
class SolutionComplementer {

    private Complementary complementer;

    /**
     * It modifies given solution. It is setting solution.complementedContent attribute.
     * @param solution
     */
    public void complement(Solution solution, String fileName) {
        switch (solution.getLanguage()) {
            case JAVA:
                complementer = new JavaComplementer(fileName);
                break;
            case CPP:
                complementer = new CppComplementer();
                break;
            case PYTHON:
                complementer = new PythonComplementer();
                break;
            default:
                log.error("The specified language is not yet supported.");
                throw new IllegalArgumentException();
        }
        complementer.complement(solution);
    }
}
