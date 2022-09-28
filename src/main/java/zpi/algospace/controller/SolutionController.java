package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.dto.SolutionDTO;
import zpi.algospace.repository.TaskRepository;
import zpi.algospace.repository.UserRepository;
import zpi.algospace.solution.SolutionService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Tag(name = "Solution Judge")
@Slf4j
@RequestMapping({"/solution", "/api/solution"})
public class SolutionController {
    private final SolutionService solutionService;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @PostMapping("/check")
    @Operation(
            summary = "Judges function.",
            description = "Judges if function written by user is correct."
    )
    public Boolean judgeSolution(@RequestBody SolutionDTO solution) {

        try {
            return solutionService.judgeSolution(solution.toSolution(taskRepository, userRepository));
        } catch (IOException | InterruptedException e) {
            log.error("Failed to execute given solution", e);
            return false;
        }
    }
}
