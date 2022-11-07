package zpi.algospace.syntax;

import zpi.algospace.model.Code;

import java.io.IOException;

public class JavaSyntaxChecker extends SyntaxChecker {
    public JavaSyntaxChecker(Code code) throws IOException {
        super(code);
    }

    @Override
    public String checkSyntax() {
        return "false";
    }
}
