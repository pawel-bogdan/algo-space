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
class JavaSyntaxCheckerTest {
    @SneakyThrows
    @ParameterizedTest
    @MethodSource
    public void checkJavaSyntax(String javaCode, boolean expectError) {
        //when
        JavaSyntaxChecker javaSyntaxChecker = new JavaSyntaxChecker(new Code(Language.JAVA, javaCode));
        String result = javaSyntaxChecker.checkSyntax();
        System.out.println(result);

        //then
        assertThat(!result.isEmpty()).isEqualTo(expectError);
    }

    private static Stream<Arguments> checkJavaSyntax() {
        //given
        String javaCorrectCode = """
                static int biggestNumber(int[] numbers) {
                        int biggest = numbers[0];
                        for(int i = 1; i < numbers.length; i++) {
                            if(biggest < numbers[i]) {
                                biggest = numbers[i];
                            }
                        }
                        return biggest;
                    }
                """;
        String javaIncorrectCodeA = """
                static int biggestNumber(int[] numbers) {
                        int biggest = numbers[0];
                        for(int i = 1; i < numbers.length; i++) {
                            if(biggest < numbers[i]) {
                                biggest = numbers[i]
                            }
                        }
                        return biggest
                    }
                """;
        String javaIncorrectCodeB = """
                static int biggestNumber(int[] numbers) {
                        int biggest = numbers.atPos(1);
                        for(int i = 1; i < numbers.length; i++) {
                            if(biggest < numbers[i]) {
                                biggest = numbers[i];
                            }
                        }
                        return biggest;
                    }
                """;

        return Stream.of(
                Arguments.of(javaCorrectCode, false),
                Arguments.of(javaIncorrectCodeA, true),
                Arguments.of(javaIncorrectCodeB, true)
        );
    }
}
