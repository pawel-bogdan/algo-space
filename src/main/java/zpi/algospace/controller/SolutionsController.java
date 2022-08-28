package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zpi.algospace.solution.SolutionsService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Tag(name = "solutionJudger")
@Slf4j
public class SolutionsController {

    final SolutionsService solutionsService;

    //nie bedzie boolean tylko jakas klasa w stylu SolutionResult
    @PostMapping("/checkSolution/{taskId}/{language}")
    public Boolean judgeSolution(
            @RequestBody String sourceCode,
            @PathVariable int taskId,
            @PathVariable String language) throws IOException, InterruptedException {
        return solutionsService.judgeFunction(taskId, language, 0, sourceCode);
    }

}
//testowa metoda
//{     "userId": 0,
//        "sourceCode": "public static void run(){ System.out.println("testOutput");}"
//}

