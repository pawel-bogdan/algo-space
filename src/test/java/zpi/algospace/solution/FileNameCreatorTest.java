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
class FileNameCreatorTest {

    @Test
    void createFileName() {
        //given
        long taskId = 1L;
        long solutionId = 1L;
        Language solutionLanguage = Language.JAVA;
        Task task = Task.builder().id(taskId).build();
        Solution solution = Solution.builder().id(solutionId).task(task).language(solutionLanguage).build();
        UUID uuid = new UUID(1L, 1L);

        try (MockedStatic<UUID> utilities = Mockito.mockStatic(UUID.class)) {
            utilities.when(UUID::randomUUID).thenReturn(uuid);

            //when
            String createdName = FileNameCreator.createFileName(solution);

            //then
            assertThat(createdName).isEqualTo("sol1_task1_java_" + String.valueOf(uuid).replace("-", StringUtils.EMPTY));
        }
    }
}
