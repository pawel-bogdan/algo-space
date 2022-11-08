package zpi.algospace.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zpi.algospace.model.Solution;
import zpi.algospace.model.dto.SolutionDTO;
import zpi.algospace.repository.ApplicationUserRepository;
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

    public Boolean judgeSolution(SolutionDTO solutionDTO) {
        Solution solution = convertToSolution(solutionDTO);
        String jobId = JobIdentifierCreator.createJobId(solution);
        try {
            SolutionComplementer.complement(solution, jobId);
        } catch (IllegalArgumentException e) {
            return INVALID_SOLUTION;
        }
        return solutionHandler.handle(solution, jobId);
    }

    private Solution convertToSolution(SolutionDTO solutionDTO) {
        return Solution.builder()
                .submissionDate(solutionDTO.getSubmissionDate())
                .content(solutionDTO.getContent())
                .language(solutionDTO.getLanguage())
                .task(taskRepository.findById(solutionDTO.getTaskId())
                        .orElseThrow(() -> new IllegalArgumentException("Requested task doesn't exist")))
                .solver(applicationUserRepository.findByEmail(solutionDTO.getSolverEmail())
                        .orElseThrow(() -> new IllegalArgumentException("Requested user doesn't exist")))
                .build();
    }
}
