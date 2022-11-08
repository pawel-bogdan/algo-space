package zpi.algospace.syntax;

import lombok.SneakyThrows;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import zpi.algospace.model.Code;
import zpi.algospace.model.Language;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisabledOnOs(value = OS.WINDOWS, disabledReason = "Bash, g++, python3, openjdk required")
class CppSyntaxCheckerTest {
    @SneakyThrows
    @ParameterizedTest
    @MethodSource
    public void checkCppSyntax(String cppCode, boolean expectError) {
        //when
        CppSyntaxChecker cppSyntaxChecker = new CppSyntaxChecker(new Code(Language.CPP, cppCode));
        String result = cppSyntaxChecker.checkSyntax();
        System.out.println(result);

        //then
        assertThat(!result.isEmpty()).isEqualTo(expectError);
    }

    private static Stream<Arguments> checkCppSyntax() {
        //given
        String cppCorrectCode = """
                int biggestNumber(int numbers[]) {
                    int biggestNumber = numbers[0];
                    for(int i = 1; i < *(&numbers + 1) - numbers; i++) {
                            if(biggestNumber < numbers[i]) {
                                biggestNumber = numbers[i];
                            }
                        }
                    return biggestNumber;
                }
                """;
        String cppIncorrectCode = """
                int biggestNumber(int numbers[]) {
                    int biggestNumber = numbers[0];
                    for(int i = 1; i < *(&numbers + 1) - numbers; i++) {
                            if(biggestNumber < numbers[i]) {
                                biggestNumber = numbers[i]
                            }
                        }
                    return biggestNumber;
                }
                """;

        return Stream.of(
                Arguments.of(cppCorrectCode, false),
                Arguments.of(cppIncorrectCode, true)
        );
    }
}
