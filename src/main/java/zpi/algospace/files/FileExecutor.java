package zpi.algospace.files;

import lombok.Data;
import zpi.algospace.model.FileNames;

import java.io.File;
import java.util.List;

@Data
public abstract class FileExecutor {
    private static String filesDirectory = "/home/";

    private final String fileName;
    private final String sourceCode;
    private File errorFile;
    private File outputFile;
    private File inputFile;

    public FileExecutor(String fileName, String sourceCode) {
        this.fileName = fileName;
        this.sourceCode = sourceCode;

        errorFile = new File(getFilesDirectory() + fileName + FileNames.ERROR.getFileName());
        outputFile = new File(getFilesDirectory() + fileName + FileNames.OUTPUT.getFileName());
    }

    public String getFilesDirectory() {
        return filesDirectory;
    }

    protected abstract String buildCommands(String fileName, String filesDirectory);

    public abstract List<String> getFilePathsToDelete();
}
