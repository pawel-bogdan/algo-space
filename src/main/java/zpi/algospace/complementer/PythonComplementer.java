package zpi.algospace.complementer;

import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Test;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class PythonComplementer implements Complementary {
    private static final String CLASS_CORE = """
            %s
                    
            if __name__ == "__main__":
                %s
            """;

    @Override
    public void complement(Solution solution) {
        solution.setComplementedContent(String.format(CLASS_CORE, solution.getContent(), prepareTests(solution)));
    }

    public String prepareTests(Solution solution) {
        List<Test> tests = solution.getTask().getTests();
        if (tests == null || tests.isEmpty()) {
            return StringUtils.EMPTY;
        }

        // TODO te 4 spacje...
        return tests.stream()
                .filter(t -> t.getLanguage() == Language.PYTHON)
                .map(t -> t.getContent())
                .collect(Collectors.joining("\n    "));
    }
}
