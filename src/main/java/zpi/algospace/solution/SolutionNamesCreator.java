package zpi.algospace.solution;

import lombok.experimental.UtilityClass;
import zpi.algospace.model.Solution;

import java.util.UUID;

@UtilityClass
public class SolutionNamesCreator {
    String createFileName(Solution solution) {
        return String.format(
                "user%s_task%s_%s_%s",
                solution.getSolverId(),
                solution.getTaskId(),
                solution.getLanguage().getName(),
                String.valueOf(UUID.randomUUID()).replace("-", "")
        );
    }
}
