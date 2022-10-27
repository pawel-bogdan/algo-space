package zpi.algospace.files;

import org.springframework.stereotype.Component;
import zpi.algospace.files.config.ProgramConfig;

import java.io.IOException;

@Component
public class ProgramRunner {
    public void run(ProgramConfig programConfig) throws IOException, InterruptedException {
        new zpi.algospace.process.ProgramRunner(programConfig).run();
    }
}
