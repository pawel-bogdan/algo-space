package zpi.algospace.files;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyMessageFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import zpi.algospace.docker.DockerClientFactory;
import zpi.algospace.files.config.ProgramConfig;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProgramRunner {
    @Value("${docker.host}")
    private String dockerHost;
    @Value("${worker.imageName}")
    private String workerImageName;
    @Value("${docker.network}")
    private String dockerNetwork;
    private final ReplyingKafkaTemplate<String, String, String> solutionResultTemplate;

    @SneakyThrows
    public void run(ProgramConfig programConfig, String content, String file) {

        RequestReplyMessageFuture<String, String> result = solutionResultTemplate.sendAndReceive(
                MessageBuilder.withPayload("").setHeader(KafkaHeaders.CORRELATION_ID, 1).build()
        );

        DockerClient dockerClient = DockerClientFactory.getDockerClient(dockerHost);

        log.debug("Giving code: " + content);
        log.debug("Giving commands: " + programConfig.getCommandsTMP());
        log.debug("Giving file name: " + file);
        CreateContainerResponse container = dockerClient
                .createContainerCmd(workerImageName)
                .withNetworkMode(dockerNetwork)
                .withEnv(
                        String.format("CODE=%s", content),
                        String.format("COMMANDS=%s", programConfig.getCommandsTMP()),
                        String.format("FILENAME=%s", file)
                ).exec();

        dockerClient.startContainerCmd(container.getId()).exec();

        String codeOutput = (String) result.get(10, TimeUnit.SECONDS).getPayload();
        log.info("Output: " + codeOutput);

    }
}
