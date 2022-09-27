package zpi.algospace;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import zpi.algospace.complementer.JavaComplementer;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Task;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class JavaComplementerTest {

    private JavaComplementer uut = new JavaComplementer("Solution");

    /*@Test
    void complement() {
        // given
        Task task = Mockito.mock(Task.class);
        Mockito.when(task.getTests()).thenReturn(List.of(new zpi.algospace.model.Test(), ))

        String solutionContent = String.join(StringUtils.LF,
                "int solution(String word) {",
                "   return word.length();",
                "}");
        Solution solution = Solution.builder()
                .id(101L)
                .content(solutionContent)
                .language(Language.JAVA)
                .task()
                .build();
        // when

        // then
    }*/
}