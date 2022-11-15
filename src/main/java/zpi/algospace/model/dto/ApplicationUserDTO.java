package zpi.algospace.model.dto;

import lombok.Data;
import zpi.algospace.model.ApplicationUser;

@Data
public class ApplicationUserDTO {
    private final String username;
    private final Integer points;

    public ApplicationUserDTO(ApplicationUser user) {
        this.username = user.getUsername();
        this.points = user.getPoints();
    }
}
