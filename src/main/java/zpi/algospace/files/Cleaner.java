package zpi.algospace.files;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Slf4j
public class Cleaner {
    public static void cleanDirectory(List<String> filePathsToDelete) {
        for (String filePath : filePathsToDelete) {
            log.debug("Deleting file: " + filePath);
            try {
                Files.deleteIfExists(Path.of(filePath));
            } catch (IOException e) {
                log.error("Failed to delete file: {}", filePath, e);
            }
        }
    }
}
