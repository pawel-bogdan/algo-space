package zpi.algospace.process;

import zpi.algospace.files.config.ProgramConfig;

import java.io.File;
import java.io.IOException;

public class ProgramRunner {
    private final File input;
    private final File error;
    private final File output;
    private final String con;

    public ProgramRunner(ProgramConfig programConfig, String con) {
        this.input = programConfig.getInputFile();
        this.error = programConfig.getErrorFile();
        this.output = programConfig.getOutputFile();
        this.con=con;
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
