package zpi.algospace.solution;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Task;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class JobIdentifierCreatorTest {
    @Test
    void createJobId() {
        //given
        long taskId = 1L;
        Language solutionLanguage = Language.JAVA;
        Task task = Task.builder().id(taskId).build();
        Solution solution = Solution.builder().task(task).language(solutionLanguage).build();
        UUID uuid = new UUID(1L, 1L);

        try (MockedStatic<UUID> utilities = Mockito.mockStatic(UUID.class)) {
            utilities.when(UUID::randomUUID).thenReturn(uuid);
            String expectedResult = "sol_task1_Java_" + String.valueOf(uuid).replace("-", StringUtils.EMPTY);

            //when
            String result = JobIdentifierCreator.createJobId(solution);

            //then
            assertThat(result).isEqualTo(expectedResult);
        }
    }
}
