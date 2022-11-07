import java.io.File;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SolutionExecutor {
    public static void main(String[] args) throws IOException, InterruptedException {
        String code = System.getenv(args[0]);
        String commands = System.getenv(args[1]);
        String fileName = System.getenv(args[2]);
        String extension = System.getenv(args[3]);
        String redis = System.getenv(args[4]);

        File input = new File(String.format("%s_input.txt", fileName));
        File output = new File(String.format("%s_output.txt", fileName));
        File error = new File(String.format("%s_error.txt", fileName));
        File codeFile = new File(String.format("%s%s", fileName, extension));

        Files.writeString(input.toPath(), commands, StandardCharsets.UTF_8);
        Files.writeString(codeFile.toPath(), code, StandardCharsets.UTF_8);

        new ProcessBuilder("bash").redirectInput(input).redirectOutput(output).redirectError(error).start().waitFor();

        String solutionOutput = Files.readString(output.toPath(), StandardCharsets.UTF_8);

        new ProcessBuilder("bash").command("/usr/local/bin/redis-cli", "-h", redis, "LPUSH", fileName, solutionOutput).start().waitFor();
    }
}
