package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.Solution;
import zpi.algospace.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "User Controller")
@RequestMapping({"/", "/api"})
@CrossOrigin(origins = {"${allowed.origin}"})
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get solutions of given user.")
    public ResponseEntity<List<Solution>> getSolutions(@PathVariable String userId) {
        log.info(" >>> Request got. /user/{}", userId);
        List<Solution> solutions;
        try {
            solutions = userService.findSolutions(userId);
        } catch (IllegalArgumentException ex) {
            log.error(">>> Cannot find user with given id: {}", userId);
            return ResponseEntity.notFound().build();
        }
        log.info(" >>> Returned response with data: {}", solutions);
        return ResponseEntity.ok(solutions);
    }
}
