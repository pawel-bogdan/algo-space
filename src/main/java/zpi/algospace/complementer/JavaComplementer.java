package zpi.algospace.complementer;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Test;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class JavaComplementer implements Complementary {

    private static final String IMPORTS = "import java.util.*; import java.lang.Math.*; ";
    private static final String CLASS_CORE = "public class %s { public static void main(String[] args) {%s} %s}";

    private String className;

    @Override
    public void complement(Solution solution) {
        solution.setComplementedContent(IMPORTS + String.format(CLASS_CORE, className, prepareTests(solution), solution.getContent()));
    }

    private String prepareTests(Solution solution) {
        List<Test> tests = solution.getTask().getTests();
        if (tests == null)
            return "";
        return tests.stream()
                .filter(t -> t.getLanguage() == Language.JAVA)
                .map(Test::getContent)
                .collect(Collectors.joining(StringUtils.LF));
    }
}
