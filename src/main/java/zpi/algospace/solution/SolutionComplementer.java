package zpi.algospace.solution;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zpi.algospace.complementer.CppComplementer;
import zpi.algospace.complementer.JavaComplementer;
import zpi.algospace.complementer.PythonComplementer;
import zpi.algospace.model.Solution;

import java.util.UUID;


@Slf4j
@Component
class SolutionComplementer {

    public String complement(Solution solution) {
        String fileName = createFileName(solution);
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

    // przyklad:  user8_task19_java_8648e80374a946cfa749703d33f9e5d9
    private String createFileName(Solution solution) {
        return "user" + solution.getSolver().getId() + "_task" + solution.getTask().getId() + "_" +
                solution.getLanguage().getName() + "" + String.valueOf(UUID.randomUUID()).replace("-", "");
    }
}
