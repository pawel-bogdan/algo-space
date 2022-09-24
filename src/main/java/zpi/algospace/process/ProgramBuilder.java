package zpi.algospace.process;

import lombok.AllArgsConstructor;

import java.io.File;
import java.io.IOException;

@AllArgsConstructor
public class ProgramBuilder {
    File input;
    File error;
    File output;

    public void run() throws IOException, InterruptedException {
        ProcessBuilder process = new ProcessBuilder("bash");
        process.redirectInput(input);
        process.redirectOutput(output);
        process.redirectError(error);

        process.start().waitFor();
    }
}
