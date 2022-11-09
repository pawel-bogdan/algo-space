package zpi.algospace.syntax;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import zpi.algospace.model.Code;
import zpi.algospace.model.Language;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled("Bash, g++, python3, openjdk required")
class PythonSyntaxCheckerTest {
    @SneakyThrows
    @ParameterizedTest
    @MethodSource
    public void checkPythonSyntax(String pythonCode, boolean expectError) {
        //when
        PythonSyntaxChecker pythonSyntaxChecker = new PythonSyntaxChecker(new Code(Language.PYTHON, pythonCode));
        String result = pythonSyntaxChecker.checkSyntax();
        System.out.println(result);

        //then
        assertThat(!result.isEmpty()).isEqualTo(expectError);
    }

    private static Stream<Arguments> checkPythonSyntax() {
        //given
        String pythonCorrectCode = """
                def biggestNumber(numbers):
                    numbers.sort()
                    return numbers[-1]
                """;
        String pythonIncorrectCodeA = """
                def biggestNumber(numbers):
                    numbers.sort()
                     return numbers[-1]
                """;
        String pythonIncorrectCodeB = """
                def biggestNumber(numbers):
                    headers = {'a': 1, 'b': 2 'c': 3 }
                    numbers.sort()
                    return numbers[-1]
                """;

        return Stream.of(
                Arguments.of(pythonCorrectCode, false),
                Arguments.of(pythonIncorrectCodeA, true),
                Arguments.of(pythonIncorrectCodeB, true)
        );
    }
}
