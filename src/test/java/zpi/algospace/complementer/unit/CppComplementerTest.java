package zpi.algospace.complementer.unit;

import org.junit.jupiter.api.Test;
import zpi.algospace.complementer.CppComplementer;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Task;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CppComplementerTest {

    private CppComplementer uut = new CppComplementer();

    @Test
    void complement() {
        // given
        Task task = Task.builder()
                .tests(List.of(
                        new zpi.algospace.model.Test("cout<<solution(\"test1\")<<endl;", Language.CPP),
                        new zpi.algospace.model.Test("cout<<solution(\"test2\")<<endl;", Language.CPP),
                        new zpi.algospace.model.Test("cout<<solution(\"test3\")<<endl;", Language.CPP)
                ))
                .build();

        String solutionContent = """
                int solution(string word) {
                    return word.size();
                }""";

        Solution solution = Solution.builder()
                .id(101L)
                .content(solutionContent)
                .language(Language.CPP)
                .task(task)
                .build();

        // when
        uut.complement(solution);

        // then
        String expectedComplementedContent = """
            #include <iostream>
            #include <stdio.h>
            using namespace std;
            
            int solution(string word) {
                return word.size();
            }
            
            int main() {
            cout<<solution("test1")<<endl;cout<<solution("test2")<<endl;cout<<solution("test3")<<endl;
            }
            """;

        assertEquals(expectedComplementedContent, solution.getComplementedContent());
    }

}