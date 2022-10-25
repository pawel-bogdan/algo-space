package zpi.algospace.process;

import zpi.algospace.files.config.ProgramConfig;

import java.io.File;
import java.io.IOException;

public class ProgramRunner {
    private final File input;
    private final File error;
    private final File output;

    public ProgramRunner(ProgramConfig programConfig) {
        this.input = programConfig.getInputFile();
        this.error = programConfig.getErrorFile();
        this.output = programConfig.getOutputFile();
    }

    public void run() throws IOException, InterruptedException {
        new ProcessBuilder("bash")
                .redirectInput(input)
                .redirectOutput(output)
                .redirectError(error)
                .start()
                .waitFor();
    }
}
