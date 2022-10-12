package zpi.algospace.complementer;

import org.apache.commons.lang3.StringUtils;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Test;

import java.util.List;
import java.util.stream.Collectors;

public interface Complementary {
    void complement(Solution solution);
    default String prepareTests(Solution solution, Language language) {
        List<Test> tests = solution.getTask().getTests();
        if (tests == null || tests.isEmpty()) {
            return StringUtils.EMPTY;
        }

        return tests.stream()
                .filter(t -> t.getLanguage() == language)
                .map(t -> t.getContent())
                .collect(Collectors.joining(StringUtils.EMPTY));
    }
}
