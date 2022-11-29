package zpi.algospace.complementer.unit;

import org.junit.jupiter.api.Test;
import zpi.algospace.complementer.PythonComplementer;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Task;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PythonComplementerTest {
    private final PythonComplementer uut = new PythonComplementer();

    @Test
    void complement() {
        // given
        Task task = Task.builder()
                .tests(List.of(
                        new zpi.algospace.model.Test("print(solution(\"test1\"))", Language.PYTHON),
                        new zpi.algospace.model.Test("print(solution(\"test2\"))", Language.PYTHON),
                        new zpi.algospace.model.Test("print(solution(\"test3\"))", Language.PYTHON)
                ))
                .build();

        String solutionContent = """
                def solution(word):
                    return len(word)""";

        Solution solution = Solution.builder()
                .id(101L)
                .content(solutionContent)
                .language(Language.PYTHON)
                .task(task)
                .build();

        // when
        uut.complement(solution);

        // then
        String expectedComplementedContent = """
            def solution(word):
                return len(word)
                    
            if __name__ == "__main__":
                print(solution("test1"))
                print(solution("test2"))
                print(solution("test3"))
            """;

        assertEquals(expectedComplementedContent, solution.getComplementedContent());
    }
}
