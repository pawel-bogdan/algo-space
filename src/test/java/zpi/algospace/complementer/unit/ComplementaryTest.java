package zpi.algospace.complementer.unit;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import zpi.algospace.complementer.Complementary;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Task;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

class ComplementaryTest {

    Complementary uut = spy(Complementary.class);

    @Test
    void testsExistForGivenLanguageThenReturnConcatenated() {
        // given
        Task task = Task.builder()
                .tests(List.of(
                        new zpi.algospace.model.Test("System.out.println(solution(\"test1\"));", Language.JAVA),
                        new zpi.algospace.model.Test("cout<<solution(\"test2\")<<endl;", Language.CPP),
                        new zpi.algospace.model.Test("System.out.println(solution(\"test3\"));", Language.JAVA),
                        new zpi.algospace.model.Test("print(solution(\"test3\"))", Language.PYTHON)
                ))
                .build();

        Solution solution = Solution.builder()
                .id(101L)
                .language(Language.JAVA)
                .task(task)
                .build();

        // when
        String result = uut.prepareTests(solution, Language.JAVA);

        // then
        String expectedResult = "System.out.println(solution(\"test1\"));System.out.println(solution(\"test3\"));";
        assertEquals(expectedResult, result);
    }

    @Test
    void testsDontExistForGivenLanguageThenReturnEmptyString() {
        // given
        Task task = Task.builder()
                .tests(List.of(
                        new zpi.algospace.model.Test("cout<<solution(\"test2\")<<endl;", Language.CPP),
                        new zpi.algospace.model.Test("print(solution(\"test3\"))", Language.PYTHON)
                ))
                .build();

        Solution solution = Solution.builder()
                .id(101L)
                .language(Language.JAVA)
                .task(task)
                .build();

        // when
        String result = uut.prepareTests(solution, Language.JAVA);

        // then
        String expectedResult = StringUtils.EMPTY;
        assertEquals(expectedResult, result);
    }
}