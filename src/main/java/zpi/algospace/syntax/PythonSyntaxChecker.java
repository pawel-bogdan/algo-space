package zpi.algospace.syntax;

import zpi.algospace.model.Code;

import java.io.IOException;

public class PythonSyntaxChecker extends SyntaxChecker {
    public PythonSyntaxChecker(Code code) throws IOException {
        super(code);
    }

    @Override
    public String checkSyntax() {
        return "";
    }
}
