package zpi.algospace.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zpi.algospace.model.Code;
import zpi.algospace.syntax.CppSyntaxChecker;
import zpi.algospace.syntax.JavaSyntaxChecker;
import zpi.algospace.syntax.PythonSyntaxChecker;

import java.io.IOException;

@Service
@Slf4j
public class SyntaxService {
    private static final String SUCCESS_MESSAGE = "Success. No errors found.";

    public String checkSyntax(Code code) throws IllegalArgumentException, IOException, InterruptedException {
        String checkingOutput = handleChecking(code);
        return checkingOutput.isEmpty() ? SUCCESS_MESSAGE : checkingOutput;
    }

    private String handleChecking(Code code) throws InterruptedException, IOException {
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
