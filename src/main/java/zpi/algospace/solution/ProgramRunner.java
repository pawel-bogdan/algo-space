package zpi.algospace.solution;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zpi.algospace.files.ProgramConfig;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProgramRunner {

    public void run(ProgramConfig programConfig) throws IOException, InterruptedException {
        new zpi.algospace.process.ProgramRunner(programConfig.getInputFile(),
                programConfig.getErrorFile(),
                programConfig.getOutputFile())
                .run();
    }
}
