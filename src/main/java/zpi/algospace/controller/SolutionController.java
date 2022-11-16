package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.Solution;
import zpi.algospace.model.dto.SolutionDTO;
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
    public Boolean judgeSolution(@RequestBody SolutionDTO solution) {
        log.info(" >>> Request got. /solution/check with params: solution: {}", solution);
        return solutionService.judgeSolution(solution);
    }

    @GetMapping(value = "/all/{user}")
    @Operation(summary = "Get solutions of given user.")
    @PreAuthorize("#user == authentication.name")
    public ResponseEntity<List<Solution>> getSolutions(@RequestParam String user) {
        log.info(" >>> Request got. /user/{}", user);
        List<Solution> solutions;
        try {
            solutions = applicationUserService.findSolutions(user);
        } catch (IllegalArgumentException ex) {
            log.error(">>> Cannot find user with given id: {}", user);
            return ResponseEntity.notFound().build();
        }
        log.info(" >>> Returned response with data: {}", solutions);
        return ResponseEntity.ok(solutions);
    }
}
