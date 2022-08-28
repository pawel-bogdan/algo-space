package zpi.algospace.solution;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@UtilityClass
@Slf4j
public class Cleaner {

    public void cleanDirectory(List<String> filesToDelete) throws IOException {
        for (String filePath: filesToDelete) {
            log.info("Deleting file: " + filePath);
            Files.delete(Path.of(filePath));
        }
    }
}
