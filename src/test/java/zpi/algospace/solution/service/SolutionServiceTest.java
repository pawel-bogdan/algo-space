package zpi.algospace.solution.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import zpi.algospace.model.Language;
import zpi.algospace.model.Task;
import zpi.algospace.model.User;
import zpi.algospace.model.dto.SolutionDTO;
import zpi.algospace.repository.TaskRepository;
import zpi.algospace.repository.UserRepository;
import zpi.algospace.solution.FileNameCreator;
import zpi.algospace.solution.SolutionHandler;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class SolutionServiceTest {

    @Mock
    TaskRepository taskRepository;
    @Mock
    UserRepository userRepository;
    @Mock
    SolutionHandler solutionHandler;

    @InjectMocks
    SolutionService solutionService;

    @SneakyThrows
    @Test
    void judgeSolution() {
        //given
        long taskId = 1L;
        String solverEmail = "email";
        String fileName = "testFile";
        Mockito.when(taskRepository.findById(taskId))
                .thenReturn(Optional.of(new Task()));
        Mockito.when(userRepository.findByEmail(solverEmail))
                .thenReturn(Optional.of(new User()));
        LocalDateTime date = LocalDateTime.now();
        try (MockedStatic<FileNameCreator> utilities = Mockito.mockStatic(FileNameCreator.class)) {
            utilities.when(() -> FileNameCreator.createFileName(any()))
                    .thenReturn(fileName);
            Mockito.when(solutionHandler.handle(any(), eq(fileName)))
                    .thenReturn(true);

            SolutionDTO solutionDTO = SolutionDTO.builder()
                    .submitionDate(date)
                    .content("content")
                    .language(Language.JAVA)
                    .taskId(taskId)
                    .solverEmail(solverEmail)
                    .build();

            //when
            Boolean result = solutionService.judgeSolution(solutionDTO);

            //then
            assertThat(result).isTrue();
        }
    }
}