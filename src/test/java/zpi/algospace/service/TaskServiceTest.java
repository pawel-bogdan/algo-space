package zpi.algospace.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import zpi.algospace.model.Category;
import zpi.algospace.model.Difficulty;
import zpi.algospace.model.Task;
import zpi.algospace.model.dto.TaskDto;
import zpi.algospace.model.dto.TaskGeneralInfo;
import zpi.algospace.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskService uut;

    @Test
    public void findTasks() {
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

        when(taskRepository.findAll()).thenReturn(List.of(task1, task2, task3));
        when(taskRepository.findAllByCategory(Category.ARRAYS)).thenReturn(List.of(task1, task2));
        when(taskRepository.findAllByDifficulty(Difficulty.EASY)).thenReturn(List.of(task1, task3));
        when(taskRepository.findAllByCategoryAndDifficulty(Category.ARRAYS, Difficulty.MEDIUM)).thenReturn(List.of(task2));

        //when
        List<TaskGeneralInfo> allTasks = uut.findTasks(null, null);
        List<TaskGeneralInfo> mediumArrayCategoryTasks = uut.findTasks(Category.ARRAYS, Difficulty.MEDIUM);
        List<TaskGeneralInfo> arrayCategoryTasks = uut.findTasks(Category.ARRAYS, null);
        List<TaskGeneralInfo> easyTasks = uut.findTasks(null, Difficulty.EASY);

        //then
        List<TaskGeneralInfo> expectAll = List.of(
                task1.toTaskGeneralInfo(),
                task2.toTaskGeneralInfo(),
                task3.toTaskGeneralInfo()
        );
        assertThat(allTasks).containsExactlyElementsOf(expectAll);

        List<TaskGeneralInfo> expectMediumArrayCategoryTasks = List.of(task2.toTaskGeneralInfo());
        assertThat(mediumArrayCategoryTasks).containsExactlyElementsOf(expectMediumArrayCategoryTasks);


        List<TaskGeneralInfo> expectArrayCategoryTasks = List.of(
                task1.toTaskGeneralInfo(),
                task2.toTaskGeneralInfo()
        );
        assertThat(arrayCategoryTasks).containsExactlyElementsOf(expectArrayCategoryTasks);

        List<TaskGeneralInfo> expectEasyTasks = List.of(
                task1.toTaskGeneralInfo(),
                task3.toTaskGeneralInfo()
        );
        assertThat(easyTasks).containsExactlyElementsOf(expectEasyTasks);
    }

    @Test
    void countAllTasks() {
        when(taskRepository.count()).thenReturn(120L);
        assertThat(uut.countAllTasks()).isEqualTo(120);
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

        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        //when
        TaskDto result = uut.findTask(taskId);

        //then
        TaskDto expectedResult = new TaskDto(task);
        assertThat(result.equals(expectedResult));
        assertThrowsExactly(IllegalArgumentException.class, () -> uut.findTask(-1L),
                "Task with given id: -1 does not exist.");
    }
}
