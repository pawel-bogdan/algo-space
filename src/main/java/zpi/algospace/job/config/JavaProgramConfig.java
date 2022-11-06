package zpi.algospace.job.config;

import lombok.Getter;
import zpi.algospace.model.Language;

@Getter
public class JavaProgramConfig extends ProgramConfig {
    public JavaProgramConfig(String jobId, String sourceCode) {
        super(jobId, sourceCode);

        extension = Language.JAVA.getExtension();
        commands = getBuildCommands(jobId);
    }

    @Override
    protected String getBuildCommands(String jobId) {
        return String.format("javac %s\njava %s",
                jobId + extension,
                jobId
        );
    }
}
