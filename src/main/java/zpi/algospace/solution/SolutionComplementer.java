package zpi.algospace.solution;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zpi.algospace.complementer.CppComplementer;
import zpi.algospace.complementer.JavaComplementer;
import zpi.algospace.complementer.PythonComplementer;
import zpi.algospace.model.Solution;
import zpi.algospace.repository.TaskRepository;

@Slf4j
@RequiredArgsConstructor
@Component
class SolutionComplementer {

    private final TaskRepository taskRepository;

    public String complement(Solution solution, String fileName) {
        switch (solution.getLanguage()) {
            case JAVA:
                JavaComplementer javaComplementer = new JavaComplementer(fileName, solution.getTaskId(), taskRepository);
                return javaComplementer.complement(solution.getContent());
            case CPP:
                CppComplementer cppComplementer = new CppComplementer(solution.getTaskId(), taskRepository);
                return cppComplementer.complement(solution.getContent());
            case PYTHON:
                PythonComplementer pythonComplementer = new PythonComplementer(solution.getTaskId(), taskRepository);
                return pythonComplementer.complement(solution.getContent());
            default:
                log.error("The specified language is not yet supported.");
                throw new IllegalArgumentException();
        }
    }
}
