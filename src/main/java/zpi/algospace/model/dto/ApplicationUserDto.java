package zpi.algospace.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import zpi.algospace.model.ApplicationUser;

@Data
@RequiredArgsConstructor
public class ApplicationUserDto {
    private final String username;
    private final Integer points;

    public ApplicationUserDto(ApplicationUser user) {
        username = user.getUsername();
        points = user.getPoints();
    }
}
