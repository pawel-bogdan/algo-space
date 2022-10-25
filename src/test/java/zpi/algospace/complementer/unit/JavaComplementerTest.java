package zpi.algospace.complementer.unit;

import org.junit.jupiter.api.Test;
import zpi.algospace.complementer.JavaComplementer;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Task;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JavaComplementerTest {
    private final JavaComplementer uut = new JavaComplementer("Solution");

    @Test
    void complement() {
        // given
        Task task = Task.builder()
                .tests(List.of(
                        new zpi.algospace.model.Test("System.out.println(solution(\"test1\"));", Language.JAVA),
                        new zpi.algospace.model.Test("System.out.println(solution(\"test2\"));", Language.JAVA),
                        new zpi.algospace.model.Test("System.out.println(solution(\"test3\"));", Language.JAVA)
                ))
                .build();

        String solutionContent = """
                static int solution(String word) {
                    return word.length();
                }
                """;

        Solution solution = Solution.builder()
                .id(101L)
                .content(solutionContent)
                .language(Language.JAVA)
                .task(task)
                .build();

        // when
        uut.complement(solution);

        // then
        String expectedComplementedContent = """
            import java.util.*;
            
            public class Solution {
                public static void main(String [] args) {
                System.out.println(solution("test1"));System.out.println(solution("test2"));System.out.println(solution("test3"));
                }
                
            static int solution(String word) {
                return word.length();
            }
            
            }
            """;

        assertEquals(expectedComplementedContent, solution.getComplementedContent());
    }
}
