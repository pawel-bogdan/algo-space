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

    public void saveSolutionAndUpdatePoints(Solution solution) {
        solutionRepository.save(solution);
        applicationUserService.assign(solution);
    }
}
