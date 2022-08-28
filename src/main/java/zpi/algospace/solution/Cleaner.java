package zpi.algospace.solution;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@UtilityClass
public class Cleaner {

    public void cleanDirectory(List<String> filesToDelete) throws IOException {
        for (String filePath: filesToDelete) {
            Files.delete(Path.of(filePath));
        }
    }
}
