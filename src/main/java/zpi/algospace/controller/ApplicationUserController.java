package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.dto.ApplicationUserDTO;
import zpi.algospace.model.dto.ApplicationUserRegistrationModel;
import zpi.algospace.service.ApplicationUserService;
import zpi.algospace.service.exception.UserAlreadyExistException;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping({"/users", "/api/users"})
@RequiredArgsConstructor
@Slf4j
@Tag(name = "User Controller")
public class ApplicationUserController {
    private final ApplicationUserService applicationUserService;

    @GetMapping("/{username}")
    @Operation(summary = "Gets basic info (such as login and points) about user.")
    public ResponseEntity<ApplicationUserDTO> getUser(@PathVariable String username) {
        try {
            log.info(" >>> Request got. /users/{}", username);
            return ResponseEntity.ok(applicationUserService.findUser(username));
        } catch (UsernameNotFoundException e) {
            log.info("User with name: {} not found.", username);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    @Operation(summary = "Register user if his registration data are valid")
    public ResponseEntity postUser(@RequestBody ApplicationUserRegistrationModel applicationUserRegistrationModel) {
        log.info(" >>> Request got. /users/register");
        String username = applicationUserRegistrationModel.getUsername();
        try {
            applicationUserService.createUser(applicationUserRegistrationModel);
            return ResponseEntity.created(URI.create("/users/" + username)).build();
        } catch (UserAlreadyExistException e) {
            log.info("User with name: {} already exists.", username);
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
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
