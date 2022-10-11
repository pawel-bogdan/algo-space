package zpi.algospace.solution;

import lombok.extern.slf4j.Slf4j;
import zpi.algospace.complementer.Complementary;
import zpi.algospace.complementer.CppComplementer;
import zpi.algospace.complementer.JavaComplementer;
import zpi.algospace.complementer.PythonComplementer;
import zpi.algospace.model.Solution;

@Slf4j
public class SolutionComplementer {

    /**
     * It modifies given solution. It is setting solution.complementedContent attribute.
     *
     * @param solution
     */
    public static void complement(Solution solution, String fileName) {
        Complementary complementer;
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
        log.info("Complemented solution: {}", solution.getComplementedContent());
    }
}
