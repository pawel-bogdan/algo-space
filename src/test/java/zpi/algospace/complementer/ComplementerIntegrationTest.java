package zpi.algospace.complementer;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.repository.TaskRepository;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("mysql-test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComplementerIntegrationTest {

    private final JavaComplementer javaComplementer = new JavaComplementer("testSolution");
    private final PythonComplementer pythonComplementer = new PythonComplementer();
    private final CppComplementer cppComplementer = new CppComplementer();

    @Resource
    private TaskRepository taskRepository;
    private static EmbeddedMysqlForComplementers embeddedMysql;

    @BeforeAll
    public static void setUp() {
        embeddedMysql = new EmbeddedMysqlForComplementers();
    }

    @AfterAll
    public static void tearDown() {
        embeddedMysql.stopMySql();
    }

    @SneakyThrows
    @Test
    void javaComplement() {
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

        javaComplementer.complement(solution);

        assertThat(solution.getComplementedContent()).isEqualTo(expectedComplementedContent);
    }

    @SneakyThrows
    @Test
    void pythonComplement() {
        String expectedComplementedContent = """
                def returnInput(input):
                    return input
                     
                if __name__ == "__main__":
                    print(returnInput("siema"))
                    print(returnInput("elo"))
                 """;

        String content = """
                def returnInput(input):
                    return input""";

        Solution solution = Solution.builder()
                .id(1L)
                .content(content)
                .language(Language.PYTHON)
                .task(taskRepository.findById(1L).get())
                .build();

        pythonComplementer.complement(solution);

        assertThat(solution.getComplementedContent()).isEqualTo(expectedComplementedContent);
    }

    @SneakyThrows
    @Test
    void cppComplement() {
        String content = """
                string returnInput(string input) {
                    return input;
                }""";
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

        Solution solution = Solution.builder()
                .id(1L)
                .content(content)
                .language(Language.CPP)
                .task(taskRepository.findById(1L).get())
                .build();

        cppComplementer.complement(solution);

        assertThat(solution.getComplementedContent()).isEqualTo(expectedComplementedContent);
    }
}
