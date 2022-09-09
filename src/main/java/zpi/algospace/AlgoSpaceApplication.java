package zpi.algospace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class AlgoSpaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlgoSpaceApplication.class, args);
        System.out.println(UUID.randomUUID());
    }

}
