package zpi.algospace.solution;

import org.apache.commons.lang3.StringUtils;
import zpi.algospace.model.Solution;

import java.util.UUID;

public class JobIdentifierCreator {
    public static String createJobId(Solution solution) {
        return String.format("sol_task%s_%s_%s",
                solution.getTask().getId(),
                solution.getLanguage().getName(),
                String.valueOf(UUID.randomUUID()).replace("-", StringUtils.EMPTY)
        );
    }
}
