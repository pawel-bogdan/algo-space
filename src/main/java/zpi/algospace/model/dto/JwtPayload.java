package zpi.algospace.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtPayload {
    private String username;
    private String token;
}
