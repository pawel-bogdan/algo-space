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
    private static final String IMPORTS = "#include <bits/stdc++.h>\nusing namespace std;";
    private static final String CLASS_CORE = " %s int main() { %s }";

    @Override
    public void complement(Solution solution) {
        solution.setComplementedContent(IMPORTS + String.format(CLASS_CORE, solution.getContent(), prepareTests(solution)));
    }

    public String prepareTests(Solution solution) {
        List<Test> tests = solution.getTask().getTests();
        if (tests == null)
            return "";
        return tests.stream()
                .filter(t -> t.getLanguage() == Language.CPP)
                .map(Test::getContent)
                .collect(Collectors.joining(StringUtils.LF));
    }
}
