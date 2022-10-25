package zpi.algospace.solution.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import zpi.algospace.model.Category;
import zpi.algospace.model.Difficulty;
import zpi.algospace.model.Task;
import zpi.algospace.model.dto.TaskDTO;
import zpi.algospace.model.dto.TaskGeneralInfo;
import zpi.algospace.repository.TaskRepository;
import zpi.algospace.service.TaskService;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskService taskService;

    @Test
    public void findTasksTest() {
        //given
        Task task1 = Task.builder()
                .category(Category.ARRAYS)
                .difficulty(Difficulty.EASY)
                .build();
        Task task2 = Task.builder()
                .category(Category.ARRAYS)
                .difficulty(Difficulty.MEDIUM)
                .build();
        Task task3 = Task.builder()
                .category(Category.SORTING)
                .difficulty(Difficulty.EASY)
                .build();

        Mockito.when(taskRepository.findAll())
                .thenReturn(List.of(task1, task2, task3));
        Mockito.when(taskRepository.findAllByCategory(Category.ARRAYS))
                .thenReturn(List.of(task1, task2));
        Mockito.when(taskRepository.findAllByDifficulty(Difficulty.EASY))
                .thenReturn(List.of(task1, task3));
        Mockito.when(taskRepository.findAllByCategoryAndDifficulty(
                        Category.ARRAYS,
                        Difficulty.MEDIUM))
                .thenReturn(List.of(task2));

        //when
        List<TaskGeneralInfo> allTasks = taskService.findTasks(null, null);
        List<TaskGeneralInfo> mediumArrayCategoryTasks = taskService.findTasks(Category.ARRAYS, Difficulty.MEDIUM);
        List<TaskGeneralInfo> arrayCategoryTasks = taskService.findTasks(Category.ARRAYS, null);
        List<TaskGeneralInfo> easyTasks = taskService.findTasks(null, Difficulty.EASY);

        //then
        List<TaskGeneralInfo> expectAll = List.of(
                task1.toTaskGeneralInfo(),
                task2.toTaskGeneralInfo(),
                task3.toTaskGeneralInfo()
        );
        compareLists(expectAll, allTasks);

        List<TaskGeneralInfo> expectMediumArrayCategoryTasks = List.of(task2.toTaskGeneralInfo());
        compareLists(expectMediumArrayCategoryTasks, mediumArrayCategoryTasks);

        List<TaskGeneralInfo> expectArrayCategoryTasks = List.of(
                task1.toTaskGeneralInfo(),
                task2.toTaskGeneralInfo()
        );
        compareLists(expectArrayCategoryTasks, arrayCategoryTasks);

        List<TaskGeneralInfo> expectEasyTasks = List.of(
                task1.toTaskGeneralInfo(),
                task3.toTaskGeneralInfo()
        );
        compareLists(expectEasyTasks, easyTasks);
    }

    private void compareLists(List<TaskGeneralInfo> expected, List<TaskGeneralInfo> actual){
        IntStream.range(0, expected.size())
                .mapToObj(i -> assertThat(actual.get(i)).isEqualTo(expected.get(i)));
    }

    @Test
    void findTask() {
        //given
        long taskId = 1L;
        Task task = Task.builder()
                .id(taskId)
                .difficulty(Difficulty.EASY)
                .category(Category.ARRAYS)
                .build();
        Mockito.when(taskRepository.findById(taskId))
                .thenReturn(Optional.of(task));
        TaskDTO expectedResult = new TaskDTO(task);

        //when
        TaskDTO result = taskService.findTask(taskId);

        //then
        assertThat(result.equals(expectedResult));
        assertThrows(
                IllegalArgumentException.class,
                () -> taskService.findTask(0L)
        );
    }
}
