package zpi.algospace.solution;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class ProgramResultValidator {
    public Boolean validateResult(String readString, long taskId) {
        log.info("Received output: {}", readString);
        return Objects.equals(readString.trim(), "hello");
    }
}
