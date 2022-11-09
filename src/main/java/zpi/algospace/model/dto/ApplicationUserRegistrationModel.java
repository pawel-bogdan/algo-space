package zpi.algospace.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class ApplicationUserRegistrationModel {
    @Email
    private final String email;
    private final String password1;
    private final String password2;
}
