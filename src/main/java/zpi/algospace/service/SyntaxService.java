package zpi.algospace.service;

import lombok.extern.slf4j.Slf4j;
import zpi.algospace.syntax.CppSyntaxChecker;
import zpi.algospace.syntax.JavaSyntaxChecker;
import zpi.algospace.syntax.PythonSyntaxChecker;
import zpi.algospace.model.Code;

import java.io.IOException;

@Slf4j
public class SyntaxService {
    public String checkSyntax(Code code) throws IllegalArgumentException, IOException {
        String output = "";
        try {
            switch (code.getLanguage()) {
                case JAVA:
                    return new JavaSyntaxChecker(code).checkSyntax();
                case CPP:
                    return new CppSyntaxChecker(code).checkSyntax();
                case PYTHON:
                    return new PythonSyntaxChecker(code).checkSyntax();
                default:
                    log.error("The specified language is not yet supported.");
                    throw new IllegalArgumentException();
            }
        } catch (IOException e) {
            throw new IOException("Failed to check syntax of given code");
        }
    }
}
