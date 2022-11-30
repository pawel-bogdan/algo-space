package zpi.algospace.complementer;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import zpi.algospace.EmbeddedMysql;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.repository.TaskRepository;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("mysql-test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComplementerIntegrationTest {
    private static EmbeddedMysql embeddedMysql;
    private final JavaComplementer javaComplementer = new JavaComplementer("testSolution");
    private final PythonComplementer pythonComplementer = new PythonComplementer();
    private final CppComplementer cppComplementer = new CppComplementer();

    @Resource
    private TaskRepository taskRepository;

    @BeforeAll
    public static void setUp() {
        embeddedMysql = new EmbeddedMysql("initTasks.sql");
    }

    @AfterAll
    public static void tearDown() {
        embeddedMysql.stopMySql();
    }

    @SneakyThrows
    @Test
    void javaComplement() {
        //given
        String content = """
                static String returnInput(String input) {
                    return input;
                }
                """;

        Solution solution = Solution.builder()
                .id(1L)
                .content(content)
                .language(Language.JAVA)
                .task(taskRepository.findById(1L).get())
                .build();

        //when
        javaComplementer.complement(solution);

        //then
        String expectedComplementedContent = """
                import java.util.*;
                            
                public class testSolution {
                    public static void main(String [] args) {
                    System.out.println(returnInput("siema"));System.out.println(returnInput("elo"));
                    }
                    
                static String returnInput(String input) {
                    return input;
                }
                            
                }
                """;
        assertThat(solution.getComplementedContent()).isEqualTo(expectedComplementedContent);
    }

    @SneakyThrows
    @Test
    @Disabled //TODO
    void pythonComplement() {
        //given
        String content = """
                def returnInput(input):
                    return input""";

        Solution solution = Solution.builder()
                .id(1L)
                .content(content)
                .language(Language.PYTHON)
                .task(taskRepository.findById(1L).get())
                .build();

        //when
        pythonComplementer.complement(solution);

        //then
        String expectedComplementedContent = """
                def returnInput(input):
                    return input
                     
                if __name__ == "__main__":
                    print(returnInput("siema"))
                \tprint(returnInput("elo"))
                 """;
        assertThat(solution.getComplementedContent()).isEqualTo(expectedComplementedContent);
    }

    @SneakyThrows
    @Test
    void cppComplement() {
        //given
        String content = """
                string returnInput(string input) {
                    return input;
                }""";

        Solution solution = Solution.builder()
                .id(1L)
                .content(content)
                .language(Language.CPP)
                .task(taskRepository.findById(1L).get())
                .build();

        //when
        cppComplementer.complement(solution);

        //then
        String expectedComplementedContent = """
                #include <iostream>
                #include <stdio.h>
                using namespace std;
                            
                string returnInput(string input) {
                    return input;
                }
                            
                int main() {
                cout << returnInput("siema") << endl;cout << returnInput("elo") << endl;
                }
                """;
        assertThat(solution.getComplementedContent()).isEqualTo(expectedComplementedContent);
    }
}
