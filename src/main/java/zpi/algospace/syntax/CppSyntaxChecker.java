package zpi.algospace.syntax;

import zpi.algospace.model.Code;

import java.io.IOException;

public class CppSyntaxChecker extends SyntaxChecker {
    public CppSyntaxChecker(Code code) throws IOException {
        super(code);
    }

    @Override
    public String checkSyntax() {
        return "";
    }
}
