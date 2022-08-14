package zpi.algospace;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PythonComplementerTest {
    PythonComplementer pythonComplementer = new PythonComplementer();

    //na szybko, nic szczegolnego
    @Test
    void complement() {
        //given
        String solution = "def main():\n\tprint(\"test\")";
        String expectedResult = "import numpy as np\nif __name__ == \"__main__\":\n\tprint(\"test\")\n\ndef main():\n\tprint(\"test\")";

        //when
        String complementedSolution = pythonComplementer.complement(solution);

        //then
        assertThat(complementedSolution).isEqualTo(expectedResult);
    }
}