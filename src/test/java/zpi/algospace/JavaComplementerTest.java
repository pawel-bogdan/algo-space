package zpi.algospace;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import zpi.algospace.complementer.JavaComplementer;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class JavaComplementerTest {

    JavaComplementer javaComplementer = new JavaComplementer("javaClass");

    //na szybko, nic szczegolnego
    @Test
    void complement() {
        //given
        String solution = "static void helloWorld(){System.out.println(\"hello world!\");}";
        String expectedResult = "import java.util.*; java.lang.Math.*;" +
                "public class javaClass public static void main() (String[] args){ System.out.println(\"hello\"); } " +
                "static void helloWorld(){System.out.println(\"hello world!\");} }";

        //when
        String complementedSolution = javaComplementer.complement(solution);

        //then
        assertThat(complementedSolution).isEqualTo(expectedResult);
    }
}