package zpi.algospace.job;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.HostConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import zpi.algospace.docker.DockerClientFactory;
import zpi.algospace.job.config.ProgramConfig;
import zpi.algospace.solution.JobResultValidator;

@Component
@Slf4j
@RequiredArgsConstructor
public class JobRunner {
    private final JobResultValidator jobResultValidator;

    @Value("${docker.host}")
    private String dockerHost;
    @Value("${docker.network}")
    private String dockerNetwork;
    @Value("${spring.redis.host}")
    private String redisHost;
    @Value("${worker.imageName}")
    private String workerImageName;

    public Boolean startJob(ProgramConfig programConfig, String expectedOutput) {
        DockerClient dockerClient = DockerClientFactory.getDockerClient(dockerHost);
        CreateContainerResponse container = dockerClient.createContainerCmd(workerImageName)
                .withHostConfig(
                        HostConfig.newHostConfig()
                                .withNetworkMode(dockerNetwork)
                                .withAutoRemove(true)
                )
                .withEnv(
                        String.format("CODE=%s", programConfig.getSourceCode()),
                        String.format("COMMANDS=%s", programConfig.getCommands()),
                        String.format("FILENAME=%s", programConfig.getJobId()),
                        String.format("EXTENSION=%s", programConfig.getExtension()),
                        String.format("REDIS=%s", redisHost)
                ).exec();

        dockerClient.startContainerCmd(container.getId()).exec();

        return jobResultValidator.validateResult(programConfig.getJobId(), expectedOutput, dockerClient, container.getId());
    }
}
