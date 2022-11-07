package zpi.algospace.job.config;

import lombok.Getter;

@Getter
public abstract class ProgramConfig {
    private final String jobId;
    private final String sourceCode;

    protected String extension;
    protected String commands;

    public ProgramConfig(String jobId, String sourceCode) {
        this.jobId = jobId;
        this.sourceCode = sourceCode;
    }

    protected abstract String getBuildCommands(String jobId);
}
