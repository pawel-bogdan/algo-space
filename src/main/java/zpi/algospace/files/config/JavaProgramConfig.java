package zpi.algospace.files.config;

import lombok.SneakyThrows;
import zpi.algospace.model.FileNames;
import zpi.algospace.model.Language;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JavaProgramConfig extends ProgramConfig {
    private static final String extension = Language.JAVA.getExtension();

    private final File compiledFile;
    private final File code;

    @SneakyThrows
    public JavaProgramConfig(String sourceCode, String fileName) {
        super(fileName, sourceCode);

        code = new File(FILES_DIRECTORY + fileName + extension);
        Files.writeString(
                Path.of(FILES_DIRECTORY + fileName + extension),
                sourceCode,
                StandardCharsets.UTF_8
        );

        File input = new File(FILES_DIRECTORY + fileName + FileNames.INPUT.getName());
        super.setInputFile(input);

        String commands = getBuildCommands(fileName, FILES_DIRECTORY);
        Files.writeString(
                input.toPath(),
                commands,
                StandardCharsets.UTF_8
        );

        compiledFile = new File(FILES_DIRECTORY + fileName + ".class");
    }

    @Override
    protected String getBuildCommands(String fileName, String filesDirectory) {
        return String.format("cd %s\njavac %s\njava %s",
                filesDirectory,
                fileName + extension,
                fileName
        );
    }

    @Override
    public List<String> getFilePathsToDelete() {
        return List.of(
                code.getAbsolutePath(),
                compiledFile.getAbsolutePath(),
                super.getInputFile().getAbsolutePath(),
                super.getOutputFile().getAbsolutePath(),
                super.getErrorFile().getAbsolutePath()
        );
    }
}
