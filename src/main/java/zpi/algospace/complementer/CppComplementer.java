package zpi.algospace.complementer;

import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Test;

import java.util.List;
import java.util.stream.Collectors;

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

    // kolejnosc wazna
    @Override
    public void complement(Solution solution) {
        solution.setComplementedContent(String.format(CLASS_CORE, solution.getContent(), prepareTests(solution, Language.CPP)));
    }
}
