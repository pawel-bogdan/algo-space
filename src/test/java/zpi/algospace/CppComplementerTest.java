package zpi.algospace;

import org.junit.jupiter.api.Test;

class CppComplementerTest {
   // CppComplementer cppComplementer = new CppComplementer();

    //na szybko, nic szczegolnego
    @Test
    void complement() {
        //given
        String solution = "void execute(){cout<<\"test\"}";
        String expectedResult = "#include <bits/stdc++.h>\nusing namespace std;" +
                "int main() { cout << \"test\"; } " +
                "void execute(){cout<<\"test\"} }";

        //when
     //   String complementedSolution = cppComplementer.complement(solution);

        //then
       // assertThat(complementedSolution).isEqualTo(expectedResult);
    }
}