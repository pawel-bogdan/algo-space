package zpi.algospace.syntax;

import zpi.algospace.model.Code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public abstract class SyntaxChecker {
    protected final Code code;
    protected File input;
    protected File error;
    protected File output;

    public SyntaxChecker(Code code) throws IOException {
        this.code = code;

        input = Files.createTempFile("syntax-input-", ".txt").toFile();
        error = Files.createTempFile("syntax-error-", ".txt").toFile();
        output = Files.createTempFile("syntax-output-", ".txt").toFile();
    }

    abstract String checkSyntax();
}
