package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.Solution;
import zpi.algospace.solution.SolutionService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Tag(name = "solutionJudge")
@Slf4j
@RequestMapping({"/solution", "/api/solution"})
public class SolutionController {

    private final SolutionService solutionsService;

    //nie bedzie boolean tylko jakas klasa w stylu SolutionResult
    @PostMapping("/check")
    public Boolean judgeSolution(@RequestBody Solution solution) throws IOException, InterruptedException {
        return solutionsService.judgeSolution(solution);
    }

}
