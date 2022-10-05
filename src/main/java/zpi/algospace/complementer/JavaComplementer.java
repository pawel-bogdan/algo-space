package zpi.algospace.complementer;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Test;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class JavaComplementer implements Complementary {

    private static final String IMPORTS = "import java.util.*;";
    private static final String CLASS_TEMPLATE =
            "public class %s {\n" +
            "    public static void main(String[] args) {\n" +
            "%s\n" +
            "    }\n" +
            "\n" +
            "\tstatic %s\n" +
            "}";

    private String className;

    @Override
    public void complement(Solution solution) {
        solution.setComplementedContent(IMPORTS + "\n" + String.format(CLASS_TEMPLATE, className, prepareTests(solution), solution.getContent()));
    }

    private String prepareTests(Solution solution) {
        List<Test> tests = solution.getTask().getTests();
        if (tests == null || tests.isEmpty()) {
            return StringUtils.EMPTY;
        }

        return tests.stream()
                .filter(t -> t.getLanguage() == Language.JAVA)
                .map(t -> "\t\t" + t.getContent())
                .collect(Collectors.joining(StringUtils.LF));
    }
}
