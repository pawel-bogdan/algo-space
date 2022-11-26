package zpi.algospace.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zpi.algospace.model.Solution;
import zpi.algospace.model.dto.SolutionDto;
import zpi.algospace.repository.ApplicationUserRepository;
import zpi.algospace.repository.SolutionRepository;
import zpi.algospace.repository.TaskRepository;
import zpi.algospace.solution.JobIdentifierCreator;
import zpi.algospace.solution.SolutionComplementer;
import zpi.algospace.solution.SolutionHandler;

import java.util.Optional;

import static java.util.stream.Collectors.toSet;

@Service
@RequiredArgsConstructor
@Slf4j
public class SolutionService {
    private static final boolean INVALID_SOLUTION = false;

    private final SolutionHandler solutionHandler;
    private final TaskRepository taskRepository;
    private final ApplicationUserRepository applicationUserRepository;
    private final SolutionRepository solutionRepository;
    private final ApplicationUserService applicationUserService;

    public Boolean judgeSolution(SolutionDto solutionDTO) {
        Solution solution = convertToSolution(solutionDTO);
        saveSolutionAndUpdatePoints(solution);
        String jobId = JobIdentifierCreator.createJobId(solution);
        try {
            SolutionComplementer.complement(solution, jobId);
        } catch (IllegalArgumentException e) {
            return INVALID_SOLUTION;
        }

        boolean result = solutionHandler.handle(solution, jobId);

        if (result) {
            saveSolutionAndUpdatePoints(solution);
        }
        return result;
    }

    public void saveSolutionAndUpdatePoints(Solution solution) {
        solutionRepository.save(solution);
        var solverSolutionIds = solution.getSolver().getSolutions().stream()
                .map(Solution::getId)
                .collect(toSet());
        boolean alreadySolved = solverSolutionIds.contains(solution.getTask().getId());
        if (!alreadySolved) {
            applicationUserService.assign(solution);
        }
    }

    private Solution convertToSolution(SolutionDto solutionDTO) {
        return Solution.builder()
                .submissionDate(solutionDTO.getSubmissionDate())
                .content(solutionDTO.getContent())
                .language(solutionDTO.getLanguage())
                .task(taskRepository.findById(solutionDTO.getTaskId())
                        .orElseThrow(() -> new IllegalArgumentException("Requested task doesn't exist")))
                .solver(applicationUserRepository.findByUsername(solutionDTO.getSolverUsername())
                        .orElseThrow(() -> new IllegalArgumentException("Requested user doesn't exist")))
                .build();
    }
}
