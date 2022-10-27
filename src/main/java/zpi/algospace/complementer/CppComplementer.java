package zpi.algospace.complementer;

import lombok.NoArgsConstructor;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;

@NoArgsConstructor
public class CppComplementer implements Complementary {
    private static final String CLASS_CORE = """
            #include <iostream>
            #include <stdio.h>
            using namespace std;
            
            %s
            
            int main() {
            %s
            }
            """;

    @Override
    public void complement(Solution solution) {
        solution.setComplementedContent(String.format(CLASS_CORE, solution.getContent(), prepareTests(solution, Language.CPP)));
    }
}
