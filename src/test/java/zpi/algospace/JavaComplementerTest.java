package zpi.algospace;

import org.junit.jupiter.api.Test;
import zpi.algospace.complementer.JavaComplementer;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Task;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JavaComplementerTest {

    private JavaComplementer uut = new JavaComplementer("Solution");

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

        String solutionContent =
                "int solution(String word) {\n" +
                        "\treturn word.length();\n" +
                        "\t}";

        Solution solution = Solution.builder()
                .id(101L)
                .content(solutionContent)
                .language(Language.JAVA)
                .task(task)
                .build();

        // when
        uut.complement(solution);

        // then
        String expectedComplementedContent =
                "import java.util.*;\n" +
                        "public class Solution {\n" +
                        "    public static void main(String[] args) {\n" +
                        "\t\tSystem.out.println(solution(\"test1\"));\n" +
                        "\t\tSystem.out.println(solution(\"test2\"));\n" +
                        "\t\tSystem.out.println(solution(\"test3\"));\n" +
                        "    }\n" +
                        "\n" +
                        "\tstatic int solution(String word) {\n" +
                        "\treturn word.length();\n" +
                        "\t}\n" +
                        "}";

        assertEquals(expectedComplementedContent, solution.getComplementedContent());
    }
}