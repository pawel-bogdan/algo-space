package zpi.algospace.solution;

import zpi.algospace.model.Solution;

import java.util.UUID;

public class FileNameCreator {
    public static String createFileName(Solution solution) {
        return String.format(
                "sol%s_task%s_%s_%s",
                solution.getId(),
                solution.getTask().getId(),
                solution.getLanguage().getName(),
                String.valueOf(UUID.randomUUID()).replace("-", "")
        );
    }
}
