package zpi.algospace.services;

import org.springframework.stereotype.Service;
import zpi.algospace.Category;
import zpi.algospace.Task;
import zpi.algospace.models.Difficulty;
import zpi.algospace.models.dto.TaskGeneralInfo;
import zpi.algospace.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskGeneralInfo> findAllTasks() {
        return taskRepository.findAll().stream().map(Task::toTaskGeneralInfo).collect(Collectors.toList());
    }

    public List<TaskGeneralInfo> findTasks(Optional<Category> category, Optional<Difficulty> difficulty) {
        List<Task> tasks = category.isPresent() ? taskRepository.findAllByCategory(category.get()) : taskRepository.findAll();
        return tasks.stream().map(Task::toTaskGeneralInfo).collect(Collectors.toList());
    }
}
