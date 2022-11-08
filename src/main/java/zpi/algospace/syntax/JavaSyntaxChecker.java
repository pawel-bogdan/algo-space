package zpi.algospace.syntax;

import org.apache.commons.lang3.tuple.Pair;
import zpi.algospace.model.Code;
import zpi.algospace.model.Language;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static zpi.algospace.syntax.CleaningErrorMessageUtils.correctLineNumbers;
import static zpi.algospace.syntax.CleaningErrorMessageUtils.findAllLineNumberOccurrences;

public class JavaSyntaxChecker extends SyntaxChecker {
    private static final String EXTENSION = Language.JAVA.getExtension();
    private static final String COMPILED_FILE_EXTENSION = ".class";
    private static final String FEEDBACK_FILE_NAME = "your_solution.java";
    private static final String CLASS_TEMPLATE = """
            import java.util.*;
                        
            class java {
            %s
            }
            """;
    private static final int LINES_ADDED_BY_CODE = 3;

    public JavaSyntaxChecker(Code code) throws IOException {
        super(code);
        formatCode(code);
    }

    @Override
    public String checkSyntax() throws IOException, InterruptedException {
        String result = checkSyntax(EXTENSION);
        Files.deleteIfExists(Path.of(codeFile.getPath()
                .replace(EXTENSION, COMPILED_FILE_EXTENSION))
        );
        return result;
    }

    @Override
    public String getSyntaxCheckingCommands() {
        return String.format("javac %s", codeFile.getPath());
    }

    @Override
    public String clearErrorMessage(String error) {
        error = error.replaceAll(codeFile.getPath(), FEEDBACK_FILE_NAME);

        ArrayList<Pair<Integer,Integer>> allFileNameOccurrences = new ArrayList<>();
        findAllLineNumberOccurrences(error, FEEDBACK_FILE_NAME + ":", allFileNameOccurrences);

        return correctLineNumbers(error, allFileNameOccurrences, LINES_ADDED_BY_CODE);
    }

    private void formatCode(Code code) {
        code.setCode(String.format(CLASS_TEMPLATE, code.getCode()));
    }
}
