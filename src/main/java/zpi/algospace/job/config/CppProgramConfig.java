package zpi.algospace.job.config;

import lombok.Getter;
import zpi.algospace.model.Language;

@Getter
public class CppProgramConfig extends ProgramConfig {
    public CppProgramConfig(String jobId, String sourceCode) {
        super(jobId, sourceCode);

        extension = Language.CPP.getExtension();
        commands = getBuildCommands(jobId);
    }

    @Override
    protected String getBuildCommands(String jobId) {
        return String.format("g++ -std=c++11 %s -o %s\n./%s",
                jobId + extension,
                jobId,
                jobId
        );
    }
}
