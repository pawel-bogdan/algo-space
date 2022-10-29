package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.dto.SolutionDTO;
import zpi.algospace.service.SolutionService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Tag(name = "Solution Judge")
@RequestMapping({"/solution", "/api/solution"})
@CrossOrigin
@Slf4j
public class SolutionController {
    private final SolutionService solutionService;

    @PostMapping("/check")
    @Operation(summary = "Judges if function written by user is correct.")
    public Boolean judgeSolution(@RequestBody SolutionDTO solution) {
        log.info(" >>> Request got. /solution/check with params: solution: {}", solution);
        try {
            return solutionService.judgeSolution(solution);
        } catch (IOException | InterruptedException e) {
            log.error("Failed to execute given solution", e);
            return false;
        }
    }
}
