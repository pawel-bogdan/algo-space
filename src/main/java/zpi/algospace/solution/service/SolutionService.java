package zpi.algospace.solution.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zpi.algospace.model.Solution;
import zpi.algospace.model.dto.SolutionDTO;
import zpi.algospace.repository.TaskRepository;
import zpi.algospace.repository.UserRepository;
import zpi.algospace.solution.FileNameCreator;
import zpi.algospace.solution.SolutionComplementer;
import zpi.algospace.solution.SolutionHandler;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class SolutionService {
    private final SolutionHandler solutionHandler;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private static final boolean INVALID_SOLUTION = false;

    public Boolean judgeSolution(SolutionDTO solutionDTO) throws IOException, InterruptedException {
        Solution solution = convertToSolution(solutionDTO);
        String fileName = FileNameCreator.createFileName(solution);
        try {
            SolutionComplementer.complement(solution, fileName);
        } catch (IllegalArgumentException e) {
            return INVALID_SOLUTION;
        }
        return solutionHandler.handle(solution, fileName);
    }

    private Solution convertToSolution(SolutionDTO solutionDTO) {
        return Solution.builder()
                .submitionDate(solutionDTO.getSubmitionDate())
                .content(solutionDTO.getContent())
                .language(solutionDTO.getLanguage())
                .task(taskRepository.findById(solutionDTO.getTaskId())
                        .orElseThrow(() -> new IllegalArgumentException("Requested task doesn't exist")))
                .solver(userRepository.findByEmail(solutionDTO.getSolverEmail())
                        .orElseThrow(() -> new IllegalArgumentException("Requested user doesn't exist")))
                .build();
    }
}
