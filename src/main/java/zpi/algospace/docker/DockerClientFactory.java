package zpi.algospace.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;

public class DockerClientFactory {
    private static final DefaultDockerClientConfig.Builder configBuilder =
            DefaultDockerClientConfig.createDefaultConfigBuilder()
                .withDockerTlsVerify(false)
                .withApiVersion("1.41");

    public static synchronized DockerClient getDockerClient(String host) {
        return DockerClientBuilder.getInstance(configBuilder.withDockerHost(host).build()).build();
    }
}
