package zpi.algospace.files;

import java.util.List;
//nie dziala
public class PythonExecutor extends FileExecutor{
    public PythonExecutor(String sourceCode, String fileName) {
        super(fileName, sourceCode);
    }

    @Override
    protected String buildCommands(String fileName, String filesDirectory) {
        return null;
    }

    @Override
    public List<String> getFilePathsToDelete() {
        return null;
    }
}
