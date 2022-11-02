package zpi.algospace.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import org.springframework.stereotype.Component;

@Component
public class DockerClientFactory {
    private static DefaultDockerClientConfig.Builder configBuilder; {
        configBuilder = DefaultDockerClientConfig.createDefaultConfigBuilder()
                .withDockerTlsVerify(false)
                .withApiVersion("1.41");
    }

    public static synchronized DockerClient getDockerClient(String host) {
        DefaultDockerClientConfig config = configBuilder.withDockerHost(host).build();
        return DockerClientBuilder.getInstance(config).build();
    }
}
