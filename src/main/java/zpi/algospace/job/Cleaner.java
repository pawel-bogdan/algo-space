package zpi.algospace.job;

import com.github.dockerjava.api.DockerClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

import java.io.IOException;

@AllArgsConstructor
@Slf4j
public class Cleaner implements Runnable {
    private DockerClient dockerClient;
    private String containerId;
    private Jedis redisClient;
    private String redisKey;
    private Boolean stopContainer;

    @Override
    public void run() {
        redisClient.del(redisKey);
        redisClient.close();

        if (stopContainer) {
            dockerClient.stopContainerCmd(containerId).exec();
        }
        try {
            dockerClient.close();
        } catch (IOException e) {
            log.error("Failed to close docker client.", e);
        }
    }
}
