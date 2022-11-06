package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.ApplicationUser;
import zpi.algospace.model.dto.ApplicationUserRegistrationModel;
import zpi.algospace.service.ApplicationUserService;

@RestController
@RequiredArgsConstructor
@Tag(name = "User Controller")
@RequestMapping({"/users", "/api/users"})
@CrossOrigin()
@Slf4j
public class ApplicationUserController {
    private final ApplicationUserService applicationUserService;

    /*@GetMapping("/{userId}")
    @Operation(summary = "Get solutions of given user.")
    public ResponseEntity<List<Solution>> getSolutions(@PathVariable String userId) {
        log.info(" >>> Request got. /user/{}", userId);
        List<Solution> solutions;
        try {
            solutions = applicationUserService.findSolutions(userId);
        } catch (IllegalArgumentException ex) {
            log.error(">>> Cannot find user with given id: {}", userId);
            return ResponseEntity.notFound().build();
        }
        log.info(" >>> Returned response with data: {}", solutions);
        return ResponseEntity.ok(solutions);
    }*/

    @PostMapping("/register")
    @Operation(summary = "Register user if his registration data are valid")
    public ResponseEntity<ApplicationUser> postUser(@RequestBody ApplicationUserRegistrationModel applicationUserRegistrationModel) {
        log.info(" >>> Request got. /users/register");
        return new ResponseEntity<>(applicationUserService.createUser(applicationUserRegistrationModel), HttpStatus.CREATED);
    }
}
