package zpi.algospace.security.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "security.jwt")
@Component
@NoArgsConstructor
@Getter
@Setter
public class JwtConfig {

    public static String AUTHORIZATION_HEADER = "Authorization";

    private String secretKey;
    private String tokenPrefix;
    private Integer minutesToTokenExpiration;

}
