package zpi.algospace.solution;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zpi.algospace.complementer.CppComplementer;
import zpi.algospace.complementer.JavaComplementer;
import zpi.algospace.complementer.PythonComplementer;
import zpi.algospace.model.Solution;

@Slf4j
@Component
class SolutionComplementer {

    public String complement(Solution solution, String fileName) {
        switch (solution.getLanguage()) {
            case JAVA:
                JavaComplementer javaComplementer = new JavaComplementer(fileName);
                return javaComplementer.complement(solution.getContent());
            case CPP:
                CppComplementer cppComplementer = new CppComplementer();
                return cppComplementer.complement(solution.getContent());
            case PYTHON:
                PythonComplementer pythonComplementer = new PythonComplementer();
                return pythonComplementer.complement(solution.getContent());
            default:
                log.error("The specified language is not yet supported.");
                throw new IllegalArgumentException();
        }
    }
}
