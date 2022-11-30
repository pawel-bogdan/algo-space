package zpi.algospace.solution;

import com.github.dockerjava.api.DockerClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import zpi.algospace.job.Cleaner;
import zpi.algospace.redis.JedisFactory;

import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class JobResultValidator {
    private static final int JOB_TIMEOUT_IN_SECONDS = 10;

    @Value("${spring.redis.host}")
    private String redisHost;
    @Value("${spring.redis.port}")
    private int redisPort;

    public Boolean validateResult(String jobId, String expectedOutput, DockerClient dockerClient, String containerId) {
        Jedis redisClient = JedisFactory.getJedisInstance(redisHost, redisPort);
        List<String> jobOutput = redisClient.blpop(JOB_TIMEOUT_IN_SECONDS, jobId);

        new Thread(
                new Cleaner(
                        dockerClient,
                        containerId,
                        redisClient,
                        jobId,
                        jobOutput == null
                )
        ).start();

        if (jobOutput != null) {
            log.debug("Successfully executed given solution with output:\n{}", jobOutput.get(1));
            log.debug("Expected output:\n{}", expectedOutput);
            return Objects.equals(
                    jobOutput.get(1).trim().toLowerCase(),
                    expectedOutput.trim().toLowerCase()
            );
        } else {
            log.debug("Failed to execute given solution.");
            return false;
        }
    }
}
