package zpi.algospace.solution;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import zpi.algospace.model.ApplicationUser;
import zpi.algospace.model.Language;
import zpi.algospace.model.Task;
import zpi.algospace.model.dto.SolutionDto;
import zpi.algospace.repository.ApplicationUserRepository;
import zpi.algospace.repository.SolutionRepository;
import zpi.algospace.repository.TaskRepository;
import zpi.algospace.service.ApplicationUserService;
import zpi.algospace.service.SolutionService;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SolutionServiceTest {
    public static final long dummyTaskId = 1L;
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
    @Disabled
    void judgeSolution() {
        //given
        String dummyUsername = "dummyUsername";
        Integer startingPoints = 30;
        ApplicationUser dummyUser = ApplicationUser.builder()
                .username(dummyUsername)
                .points(startingPoints)
                .solutions(Collections.emptyList())
                .build();

        Task dummyTask = Task.builder()
                .id(dummyTaskId)
                .build();

        String dummyJobId = "testFile";
        when(taskRepository.findById(dummyTaskId)).thenReturn(Optional.of(dummyTask));
        when(applicationUserRepository.findByUsername(dummyUsername))
                .thenReturn(Optional.of(dummyUser));

        try (MockedStatic<JobIdentifierCreator> utilities = mockStatic(JobIdentifierCreator.class)) {
            utilities.when(() -> JobIdentifierCreator.createJobId(any())).thenReturn(dummyJobId);
        }

        when(solutionHandler.handle(any(), eq(dummyJobId))).thenReturn(true);

        SolutionDto solutionDTO = SolutionDto.builder()
                .submissionDate(LocalDateTime.now())
                .content("content")
                .language(Language.JAVA)
                .taskId(dummyTaskId)
                .solverUsername(dummyUsername)
                .build();


        //when
        Boolean result = solutionService.judgeSolution(solutionDTO);

        //then
        assertThat(result).isTrue();
    }
}
