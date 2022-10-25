package zpi.algospace.files.config;

import lombok.SneakyThrows;
import zpi.algospace.model.FileNames;
import zpi.algospace.model.Language;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PythonProgramConfig extends ProgramConfig {
    private static final String extension = Language.PYTHON.getExtension();

    private final File code;

    @SneakyThrows
    public PythonProgramConfig(String sourceCode, String fileName) {
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
    }

    @Override
    protected String getBuildCommands(String fileName, String filesDirectory) {
        return String.format("cd %s\npython3 %s",
                filesDirectory,
                fileName + extension
        );
    }

    @Override
    public List<String> getFilePathsToDelete() {
        return List.of(
                code.getAbsolutePath(),
                super.getInputFile().getAbsolutePath(),
                super.getOutputFile().getAbsolutePath(),
                super.getErrorFile().getAbsolutePath()
        );
    }
}
