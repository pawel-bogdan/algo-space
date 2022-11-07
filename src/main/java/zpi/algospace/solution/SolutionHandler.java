package zpi.algospace.solution;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zpi.algospace.job.config.CppProgramConfig;
import zpi.algospace.job.config.JavaProgramConfig;
import zpi.algospace.job.config.ProgramConfig;
import zpi.algospace.job.config.PythonProgramConfig;
import zpi.algospace.job.JobRunner;
import zpi.algospace.model.Solution;

@Component
@RequiredArgsConstructor
@Slf4j
public class SolutionHandler {
    private final JobRunner programRunner;

    public Boolean handle(Solution solution, String jobId) {
        ProgramConfig programConfig = createProgramConfig(solution, jobId);

        return programRunner.startJob(programConfig, solution.getTask().getExpectedOutput());
    }

    private ProgramConfig createProgramConfig(Solution solution, String jobId) {
        final String complementedContent = solution.getComplementedContent();
        switch (solution.getLanguage()) {
            case JAVA:
                return new JavaProgramConfig(jobId, complementedContent);
            case CPP:
                return new CppProgramConfig(jobId, complementedContent);
            case PYTHON:
                return new PythonProgramConfig(jobId, complementedContent);
            default:
                log.error("The specified language is not yet supported.");
                throw new IllegalArgumentException();
        }
    }
}
