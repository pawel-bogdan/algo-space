package zpi.algospace.solution;

import org.apache.commons.lang3.StringUtils;
import zpi.algospace.model.Solution;

import java.util.UUID;

public class JobIdentifierCreator {
    public static String createJobId(Solution solution) {
        String languageName = "";
        switch (solution.getLanguage()) {
            case JAVA -> languageName = "Java";
            case CPP -> languageName = "Cpp";
            case PYTHON -> languageName = "Python";
        }
        return String.format("sol_task%s_%s_%s",
                solution.getTask().getId(),
                languageName,
                String.valueOf(UUID.randomUUID()).replace("-", StringUtils.EMPTY)
        );
    }
}
