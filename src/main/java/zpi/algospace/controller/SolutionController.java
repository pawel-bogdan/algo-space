package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.dto.SolutionDto;
import zpi.algospace.model.exception.SolutionNotFoundException;
import zpi.algospace.service.ApplicationUserService;
import zpi.algospace.service.SolutionService;

import java.util.List;

@RestController
@RequestMapping({"/solution", "/api/solution"})
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Solution Judge")
@SecurityRequirement(name = "Bearer Authentication")
public class SolutionController {
    private final SolutionService solutionService;
    private final ApplicationUserService applicationUserService;

    @PostMapping("/check")
    @Operation(summary = "Checks whether solution is correct")
    public Boolean judgeSolution(@RequestBody SolutionDto solution) {
        log.info(" >>> Request got. /solution/check with params: solution:\n{}", solution);
        return solutionService.judgeSolution(solution);
    }

    @GetMapping(value = "/all/{user}")
    @Operation(summary = "Get solutions of given user.")
    @PreAuthorize("#user == authentication.name")
    public ResponseEntity<List<SolutionDto>> getSolutions(@RequestParam String user) {
        log.info(" >>> Request got. /user/{}", user);
        List<SolutionDto> solutions;
        try {
            solutions = applicationUserService.findSolutions(user);
        } catch (IllegalArgumentException ex) {
            log.error(">>> Cannot find user with given id: {}", user);
            return ResponseEntity.notFound().build();
        }
        log.info(" >>> Returned response with data:\n{}", solutions);
        return ResponseEntity.ok(solutions);
    }

    @GetMapping(value = "/task/{taskId}/{user}")
    @Operation(summary = "Get solution for given task and user.")
    @PreAuthorize("#user == authentication.name")
    public ResponseEntity<SolutionDto> getSolution(@RequestParam Integer taskId, @RequestParam String user) {
        log.info(" >>> Request got. /task/{}/{}", taskId, user);
        SolutionDto solution;
        try {
            solution = applicationUserService.findSolution(taskId, user);
        } catch (UsernameNotFoundException e) {
            log.error(">>> Cannot find user with given id: {}", user);
            return ResponseEntity.notFound().build();
        } catch (SolutionNotFoundException e) {
            log.error(">>> Cannot find solution of user with name: {} for task with id: {}", user, taskId);
            return ResponseEntity.notFound().build();
        }
        log.info(" >>> Returned response with data:\n{}", solution);
        return ResponseEntity.ok(solution);
    }
}
