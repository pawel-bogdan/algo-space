package zpi.algospace.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Setter
@Getter
public class ApplicationUserRegistrationModel {
    @Email
    private String email;
    private String password1;
    private String password2;
}
