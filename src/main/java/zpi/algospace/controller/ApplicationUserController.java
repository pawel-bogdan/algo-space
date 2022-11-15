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
import zpi.algospace.model.dto.ApplicationUserDTO;
import zpi.algospace.model.dto.ApplicationUserRegistrationModel;
import zpi.algospace.service.ApplicationUserService;

import java.util.List;

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

    @PostMapping(value = "/username-availability", consumes = MediaType.TEXT_PLAIN_VALUE)
    @Operation(summary = "Checks if the username is already used")
    public ResponseEntity<Boolean> isUsernameAlreadyUsed(@RequestBody String username) {
        log.info(String.format(" >>> Request got. /users/username-availability with data: %s", username));
        return ResponseEntity.ok(applicationUserService.isUsernameAvailable(username));
    }

    @GetMapping("/ranking")
    @Operation(summary = "Returns users sorted by their points in descending order")
    public ResponseEntity<List<ApplicationUserDTO>> getUsers() {
        log.info(" >>> Request got. /users/ranking");
        return ResponseEntity.ok(applicationUserService.getUsersSortedByPoints());
    }
}
