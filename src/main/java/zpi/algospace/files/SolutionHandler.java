package zpi.algospace.files;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zpi.algospace.model.Language;

@Slf4j
@Component
public class SolutionHandler {
    @SneakyThrows//chwilowo bo narazie nie chce mi sie tg pozadnei obslugiwac
    public FileExecutor handle(Language language, String fileName, String complementedSolution) {
        switch (language) {
            case JAVA:
                return new JavaExecutor(complementedSolution, fileName);
            case CPP:
                return new CppExecutor(complementedSolution, fileName);
            case PYTHON:
                return new PythonExecutor(complementedSolution, fileName);
            default:
                log.error("The specified language is not yet supported.");
                throw new IllegalArgumentException();
        }
    }
}
