package zpi.algospace.syntax;

import zpi.algospace.model.Code;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

public abstract class SyntaxChecker {
    protected static final int SYNTAX_CHECKING_TIMEOUT_IN_SECONDS = 5;

    protected Code code;
    protected File codeFile;
    protected File input;
    protected File error;
    protected File output;

    public SyntaxChecker(Code code) {
        this.code = code;
    }

    protected String checkSyntax(String extension) throws IOException, InterruptedException {
        createAssistantFiles();
        createCodeFile(extension);
        String syntaxCheckingOutput = executeChecking();
        Files.deleteIfExists(codeFile.toPath());
        deleteAssistantFiles();

        return clearErrorMessage(syntaxCheckingOutput);
    }

    public abstract String checkSyntax() throws IOException, InterruptedException;

    public abstract String getSyntaxCheckingCommands();

    public abstract String clearErrorMessage(String error);

    protected String executeChecking() throws IOException, InterruptedException {
        Files.writeString(
                input.toPath(),
                getSyntaxCheckingCommands(),
                StandardCharsets.UTF_8
        );

        Files.writeString(
                codeFile.toPath(),
                code.getCode(),
                StandardCharsets.UTF_8
        );

        Process syntaxChecking = new ProcessBuilder("bash")
                .redirectInput(input)
                .redirectOutput(output)
                .redirectError(error)
                .start();

        if (!syntaxChecking.waitFor(SYNTAX_CHECKING_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)) {
            syntaxChecking.destroyForcibly();
        }

        return Files.readString(
                error.toPath(),
                StandardCharsets.UTF_8
        );
    }

    protected void createCodeFile(String extension) throws IOException {
        codeFile = Files.createTempFile("syntax-code-", extension).toFile();
    }

    protected void createAssistantFiles() throws IOException {
        input = Files.createTempFile("syntax-input-", ".txt").toFile();
        error = Files.createTempFile("syntax-error-", ".txt").toFile();
        output = Files.createTempFile("syntax-output-", ".txt").toFile();
    }

    protected void deleteAssistantFiles() throws IOException {
        Files.deleteIfExists(input.toPath());
        Files.deleteIfExists(error.toPath());
        Files.deleteIfExists(output.toPath());
    }
}
