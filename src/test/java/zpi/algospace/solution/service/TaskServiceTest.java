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
import zpi.algospace.model.dto.TaskGeneralInfo;
import zpi.algospace.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

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
        Mockito.when(taskRepository.findAllByCategoryAndAndDifficulty(
                        Category.ARRAYS,
                        Difficulty.MEDIUM))
                .thenReturn(List.of(task2));

        //when
        List<TaskGeneralInfo> listOfAll = taskService.findTasks(null, null);
        List<TaskGeneralInfo> listOfMediumArrays = taskService.findTasks(Category.ARRAYS, Difficulty.MEDIUM);
        List<TaskGeneralInfo> listOfArrays = taskService.findTasks(Category.ARRAYS, null);
        List<TaskGeneralInfo> listOfEasy = taskService.findTasks(null, Difficulty.EASY);

        //then
        List<TaskGeneralInfo> expectAll = List.of(
                task1.toTaskGeneralInfo(),
                task2.toTaskGeneralInfo(),
                task3.toTaskGeneralInfo()
        );
        compareLists(expectAll, listOfAll);

        List<TaskGeneralInfo> expectMediumArrays = List.of(task2.toTaskGeneralInfo());
        compareLists(expectMediumArrays, listOfMediumArrays);

        List<TaskGeneralInfo> expectArrays = List.of(
                task1.toTaskGeneralInfo(),
                task2.toTaskGeneralInfo()
        );
        compareLists(expectArrays, listOfArrays);

        List<TaskGeneralInfo> expectEasy = List.of(
                task1.toTaskGeneralInfo(),
                task3.toTaskGeneralInfo()
        );
        compareLists(expectEasy, listOfEasy);
    }

    private void compareLists(List<TaskGeneralInfo> expected, List<TaskGeneralInfo> actual){
        IntStream.range(0, expected.size())
                .mapToObj(i -> assertThat(actual.get(i)).isEqualTo(expected.get(i)));
    }

    @Test
    void findTask() {
        //given
        long taskId = 1L;
        Task task1 = Task.builder().build();
        Mockito.when(taskRepository.findById(1L))
                .thenReturn(Optional.of(task1));

        //when
        Optional<Task> expectTask = taskService.findTask(taskId);
        Optional<Task> expectNull = taskService.findTask(0L);

        //then
        assertThat(expectTask.get()).isEqualTo(task1);
        assertThat(expectNull).isEqualTo(Optional.empty());
    }
}
