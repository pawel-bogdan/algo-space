package zpi.algospace.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import zpi.algospace.model.Solution;
import zpi.algospace.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {

    private UserService userService;


    @GetMapping("/user/{userId}")
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
