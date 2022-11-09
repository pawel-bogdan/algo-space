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

public class CppSyntaxChecker extends SyntaxChecker {
    private static final String EXTENSION = Language.CPP.getExtension();
    private static final String CLASS_TEMPLATE = """
            #include <iostream>
            #include <stdio.h>
            using namespace std;
            
            %s
            
            int main() {
            %s
            }
            """;
    private static final int LINES_ADDED_BY_CODE = 4;

    public CppSyntaxChecker(Code code) throws IOException {
        super(code);
        formatCode(code);
    }

    @Override
    public String checkSyntax() throws IOException, InterruptedException {
        String result = checkSyntax(EXTENSION);
        Files.deleteIfExists(Path.of(codeFile.getPath()
                .replace(EXTENSION, ""))
        );
        return result;
    }

    @Override
    public String getSyntaxCheckingCommands() {
        return String.format("g++ %s -o %s",
                codeFile.getPath(),
                codeFile.getPath().replace(EXTENSION, ""));
    }

    @Override
    public String clearErrorMessage(String error) {
        error = error.replaceAll(codeFile.getPath(), FEEDBACK_FILE_NAME + EXTENSION);

        ArrayList<Pair<Integer,Integer>> allFileNameOccurrences = new ArrayList<>();
        findAllLineNumberOccurrences(error, FEEDBACK_FILE_NAME + EXTENSION + ":", allFileNameOccurrences);
        filterFileNameOccurrences(error, allFileNameOccurrences);

        return correctLineNumbers(error, allFileNameOccurrences, LINES_ADDED_BY_CODE);
    }

    private void formatCode(Code code) {
        code.setCode(String.format(CLASS_TEMPLATE,
                code.getCode(),
                "return 0;"));
    }

    private void filterFileNameOccurrences(String error, ArrayList<Pair<Integer, Integer>> allFileNameOccurrences) {
        allFileNameOccurrences.removeIf(range -> error.charAt(range.getLeft()) == ' ');
    }
}
