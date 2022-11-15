package zpi.algospace.model.dto;

import lombok.Data;

@Data
public class ApplicationUserRegistrationModel {
    private final String username;
    private final String password1;
    private final String password2;
}
