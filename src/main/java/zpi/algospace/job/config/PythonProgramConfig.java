package zpi.algospace.job.config;

import lombok.Getter;
import zpi.algospace.model.Language;

@Getter
public class PythonProgramConfig extends ProgramConfig {
    public PythonProgramConfig(String jobId, String sourceCode) {
        super(jobId, sourceCode);

        extension = Language.JAVA.getExtension();
        commands = getBuildCommands(jobId);
    }

    @Override
    protected String getBuildCommands(String jobId) {
        return String.format("python3.6 %s",
                jobId + extension
        );
    }
}
