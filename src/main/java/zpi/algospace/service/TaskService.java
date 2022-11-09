package zpi.algospace.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zpi.algospace.model.*;
import zpi.algospace.model.dto.TaskDTO;
import zpi.algospace.model.dto.TaskGeneralInfo;
import zpi.algospace.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TaskService {
    private static final String TASK_NOT_FOUND_TEXT = "Task with given id: %s does not exist.";

    private final TaskRepository taskRepository;

    public List<TaskGeneralInfo> findTasks(Category category, Difficulty difficulty) {
        List<Task> tasks;
        if (category == null && difficulty == null) {
            tasks = taskRepository.findAll();
        } else if (category == null) {
            tasks = taskRepository.findAllByDifficulty(difficulty);
        } else if (difficulty == null) {
            tasks = taskRepository.findAllByCategory(category);
        } else {
            tasks = taskRepository.findAllByCategoryAndDifficulty(category, difficulty);
        }
        return tasks.stream().map(Task::toTaskGeneralInfo).collect(Collectors.toList());
    }

    public Integer countAllTasks() {
        return (int) taskRepository.count();
    }

    public TaskDTO findTask(Long id) {
        return new TaskDTO(taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format(TASK_NOT_FOUND_TEXT, id)))
        );
    }
}
