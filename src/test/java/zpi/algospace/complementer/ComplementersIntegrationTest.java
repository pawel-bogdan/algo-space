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
import zpi.algospace.model.User;
import zpi.algospace.repository.TaskRepository;

import javax.annotation.Resource;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("mysql-test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComplementersIntegrationTest {

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
        embeddedMysql.stopMysql();
    }

    @SneakyThrows
    @Test
    void javaComplement(){
        String expectedComplementedSolution = "import java.util.*; import java.lang.Math.*; " +
                "public class testSolution { " +
                "public static void main(String[] args) {" +
                "System.out.println(returnInput(\"siema\"));\n" +
                "System.out.println(returnInput(\"elo\"));} " +
                "static String returnInput(String input) { " +
                "return input; }" +
                "}";
        String content = "static String returnInput(String input) { return input; }";
        Solution solution = Solution.builder()
                .id(1L)
                .submitionDate(LocalDateTime.now())
                .content(content)
                .language(Language.JAVA)
                .task(taskRepository.findById(1L).get())
                .solver(new User())
                .build();

        javaComplementer.complement(solution);

        assertThat(solution.getComplementedContent().trim()).isEqualTo(expectedComplementedSolution.trim());
    }

    @SneakyThrows
    @Test
    void pythonComplement(){
        String expectedComplementedSolution = "import numpy as np\n" +
                "def returnInput(input): \n" +
                "\treturn input\n" +
                "\n" +
                "if __name__ == \"__main__\":\n" +
                "\tprint(returnInput(\"siema\"))\n" +
                "\tprint(returnInput(\"elo\"))";
        String content = "def returnInput(input): \n\treturn input";
        Solution solution = Solution.builder()
                .id(1L)
                .submitionDate(LocalDateTime.now())
                .content(content)
                .language(Language.PYTHON)
                .task(taskRepository.findById(1L).get())
                .solver(new User())
                .build();

        pythonComplementer.complement(solution);

        assertThat(solution.getComplementedContent().trim()).isEqualTo(expectedComplementedSolution.trim());
    }

    @SneakyThrows
    @Test
    void cppComplement(){
        String expectedComplementedSolution = "#include <bits/stdc++.h>\n" +
                "using namespace std; string returnInput(string input){return input;} " +
                "int main() { cout << returnInput(\"siema\") << endl;\n" +
                "cout << returnInput(\"elo\") << endl; }";
        String content = "string returnInput(string input){return input;}";
        Solution solution = Solution.builder()
                .id(1L)
                .submitionDate(LocalDateTime.now())
                .content(content)
                .language(Language.CPP)
                .task(taskRepository.findById(1L).get())
                .solver(new User())
                .build();

        cppComplementer.complement(solution);

        assertThat(solution.getComplementedContent().trim()).isEqualTo(expectedComplementedSolution.trim());
    }
}
