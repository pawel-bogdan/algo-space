package zpi.algospace.solution.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import zpi.algospace.model.ApplicationUser;
import zpi.algospace.model.Language;
import zpi.algospace.model.Task;
import zpi.algospace.model.dto.SolutionDTO;
import zpi.algospace.repository.ApplicationUserRepository;
import zpi.algospace.repository.SolutionRepository;
import zpi.algospace.repository.TaskRepository;
import zpi.algospace.service.ApplicationUserService;
import zpi.algospace.service.SolutionService;
import zpi.algospace.solution.JobIdentifierCreator;
import zpi.algospace.solution.SolutionHandler;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
@Disabled //TODO trzeba bedzie go zaktualizowac
class SolutionServiceTest {
    //TODO poprawic ten ten zwiazek z bazą
    @Mock
    TaskRepository taskRepository;
    @Mock
    ApplicationUserRepository applicationUserRepository;

    @Mock
    SolutionRepository solutionRepository;

    @Mock
    ApplicationUserService applicationUserService;

    @Mock
    SolutionHandler solutionHandler;

    @InjectMocks
    SolutionService solutionService;

    @SneakyThrows
    @Test
    void judgeSolution() {
        //given
        long taskId = 1L;
        String solverUsername = "email";
        String fileName = "testFile";
        Mockito.when(taskRepository.findById(taskId))
                .thenReturn(Optional.of(new Task()));
        Mockito.when(applicationUserRepository.findByUsername(solverUsername))
                .thenReturn(Optional.of(new ApplicationUser()));
        try (MockedStatic<JobIdentifierCreator> utilities = Mockito.mockStatic(JobIdentifierCreator.class)) {
            utilities.when(() -> JobIdentifierCreator.createJobId(any()))
                    .thenReturn(fileName);
            Mockito.when(solutionHandler.handle(any(), eq(fileName)))
                    .thenReturn(true);
            SolutionDTO solutionDTO = SolutionDTO.builder()
                    .submissionDate(LocalDateTime.now())
                    .content("content")
                    .language(Language.JAVA)
                    .taskId(taskId)
                    .solverUsername(solverUsername)
                    .build();

            //when
            Boolean result = solutionService.judgeSolution(solutionDTO);

            //then
            assertThat(result).isTrue();
        }
    }
}
