package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.ApplicationUser;
import zpi.algospace.model.dto.ApplicationUserRegistrationModel;
import zpi.algospace.service.ApplicationUserService;

@RestController
@RequiredArgsConstructor
@Tag(name = "User Controller")
@RequestMapping({"/users", "/api/users"})
@CrossOrigin
@Slf4j
public class ApplicationUserController {
    private final ApplicationUserService applicationUserService;

    @PostMapping("/register")
    @Operation(summary = "Register user if his registration data are valid")
    public ResponseEntity<ApplicationUser> postUser(@RequestBody ApplicationUserRegistrationModel applicationUserRegistrationModel) {
        log.info(" >>> Request got. /users/register");
        return new ResponseEntity<>(applicationUserService.createUser(applicationUserRegistrationModel), HttpStatus.CREATED);
    }

    @PostMapping(value = "/email-availability", consumes = MediaType.TEXT_PLAIN_VALUE)
    @Operation(summary = "Checks if the given email is already used")
    public ResponseEntity<Boolean> isEmailAlreadyUsed(@RequestBody String email) {
        log.info(String.format(" >>> Request got. /users/email-availability with data: %s", email));
        return ResponseEntity.ok(applicationUserService.isEmailAvailable(email));
    }
}
