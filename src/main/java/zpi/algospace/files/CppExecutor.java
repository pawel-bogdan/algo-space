package zpi.algospace.files;

import lombok.SneakyThrows;
import zpi.algospace.model.FileNames;
import zpi.algospace.model.Language;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class CppExecutor extends FileExecutor{

    private static final String extension = Language.CPP.getExtension();
    private final File exeFile;
    private final File code;

    @SneakyThrows
    public CppExecutor(String sourceCode, String fileName) {
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

        exeFile = new File(super.getFilesDirectory() + fileName + ".exe");
    }

    @Override
    protected String buildCommands(String fileName, String filesDirectory) {
        return String.format("cd %s\ng++ %s -o %s\n./%s",
                filesDirectory,
                fileName + extension,
                fileName,
                fileName);
    }

    @Override
    public List<String> getFilePathsToDelete() {
        return List.of(
                code.getAbsolutePath(),
                exeFile.getAbsolutePath(),
                super.getInputFile().getAbsolutePath(),
                super.getOutputFile().getAbsolutePath(),
                super.getErrorFile().getAbsolutePath());
    }

}
