package zpi.algospace.solution;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Slf4j
public class Cleaner {

    public static void cleanDirectory(List<String> filePathsToDelete) throws IOException {
        for (String filePath : filePathsToDelete) {
            log.info("Deleting file: " + filePath);
            Files.deleteIfExists(Path.of(filePath));
        }
    }
}
