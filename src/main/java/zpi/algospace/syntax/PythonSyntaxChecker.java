package zpi.algospace.syntax;

import zpi.algospace.model.Code;
import zpi.algospace.model.Language;

import java.io.IOException;

public class PythonSyntaxChecker extends SyntaxChecker {
    private static final String EXTENSION = Language.PYTHON.getExtension();
    private static final String FEEDBACK_FILE_NAME = "your_solution.py";

    public PythonSyntaxChecker(Code code) throws IOException {
        super(code);
    }

    @Override
    public String checkSyntax() throws IOException, InterruptedException {
        return checkSyntax(EXTENSION);
    }

    @Override
    public String getSyntaxCheckingCommands() {
        return String.format("python3 -m py_compile %s", codeFile.getPath());
    }

    @Override
    public String clearErrorMessage(String error) {
        error = error.replaceAll(codeFile.getPath(), FEEDBACK_FILE_NAME);
        error = error.replaceAll(codeFile.getAbsoluteFile().getName(), FEEDBACK_FILE_NAME);

        return error;
    }
}
