package zpi.algospace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zpi.algospace.service.ApplicationUserService;

@SpringBootApplication
public class AlgoSpaceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlgoSpaceApplication.class, args);
    }

}
