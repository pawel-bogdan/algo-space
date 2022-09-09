package zpi.algospace.files;

import zpi.algospace.model.FileNames;
import zpi.algospace.model.Language;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JavaExecutor extends FileExecutor{

    private static final String extension = Language.JAVA.getExtension();
    private final File compiledFile;
    private final File code;

    public JavaExecutor(String sourceCode, String fileName) throws IOException {
        super(fileName, sourceCode);

        code = new File(super.getFilesDirectory() + fileName + extension);
        Files.writeString(Path.of(super.getFilesDirectory() + fileName + extension),
                sourceCode,
                StandardCharsets.UTF_8);

        File input = new File(super.getFilesDirectory() + fileName + FileNames.INPUT.getName());
        super.setInputFile(input);
        String commands = buildCommands(fileName, super.getFilesDirectory());

        Files.writeString(input.toPath(),
                commands,
                StandardCharsets.UTF_8);

        compiledFile = new File(super.getFilesDirectory() + fileName + ".class");
    }

    @Override
    protected String buildCommands(String fileName, String filesDirectory){
        return String.format("cd %s\njavac %s\njava %s",
                filesDirectory,
                fileName + extension,
                fileName);
    }

    @Override
    public List<String> getFilePathsToDelete() {
        return List.of(
                code.getAbsolutePath(),
                compiledFile.getAbsolutePath(),
                super.getInputFile().getAbsolutePath(),
                super.getOutputFile().getAbsolutePath(),
                super.getErrorFile().getAbsolutePath());
    }
}
