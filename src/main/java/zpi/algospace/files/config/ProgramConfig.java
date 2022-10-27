package zpi.algospace.files.config;

import lombok.Getter;
import lombok.Setter;
import zpi.algospace.model.FileName;

import java.io.File;
import java.util.List;

@Getter
public abstract class ProgramConfig {
    public static String FILES_DIRECTORY = "/home/";

    private final String fileName;
    private final String sourceCode;
    private final File errorFile;
    private final File outputFile;

    @Setter
    private File inputFile;

    public ProgramConfig(String fileName, String sourceCode) {
        this.fileName = fileName;
        this.sourceCode = sourceCode;

        errorFile = new File(FILES_DIRECTORY + fileName + FileName.ERROR.getName());
        outputFile = new File(FILES_DIRECTORY + fileName + FileName.OUTPUT.getName());
    }

    protected abstract String getBuildCommands(String fileName, String filesDirectory);

    public abstract List<String> getFilePathsToDelete();
}
