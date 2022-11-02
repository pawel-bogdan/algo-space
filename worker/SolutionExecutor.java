import java.io.File;
import java.io.IOException;
public class SolutionExecutor {
    public static void main(String[] args) {

        String code = System.getenv(args[0]);
        String commands = System.getenv(args[1]);
        String fileName = System.getenv(args[2]);

        File input = new File("input.txt");
        File output = new File("output.txt");
        File error = new File("error.txt");
//
//        new ProcessBuilder("bash")
//                .redirectInput(input)
//                .redirectOutput(output)
//                .redirectError(error)
//                .start()
//                .waitFor();
        System.out.println(String.format("kafka_correlationId:%s", fileName));
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command("sh", "/kafka/bin/kafka-console-producer.sh", "--topic", "request", "--bootstrap-server", "kafka:9092", "--property", "parse.headers=true", String.format("kafka_correlationId:%s", 1), "<", "ccc.txt");
            builder.start();
        } catch (IOException e){
            System.out.println("adc " + e);
        }
    }
}
