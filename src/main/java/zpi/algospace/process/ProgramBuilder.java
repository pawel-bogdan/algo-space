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
        ProcessBuilder process = new ProcessBuilder("cmd");
        process.redirectInput(input);
        process.redirectOutput(output);
        process.redirectError(error);

        Process compiling = process.start();
        //ta metoda blokuje watek wiec nwm czy tak powinno byc
        //trzeb abd sie zorietnowac czy to zwalnia jak kilka requestow naraz pojdzie i ew.
        //inaczej zrobic to
        compiling.waitFor();
    }
}
