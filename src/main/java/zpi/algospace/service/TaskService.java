package zpi.algospace.service;

import org.springframework.stereotype.Service;
import zpi.algospace.model.Category;
import zpi.algospace.model.Difficulty;
import zpi.algospace.model.Task;
import zpi.algospace.model.dto.TaskGeneralInfo;
import zpi.algospace.repository.TaskRepository;

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

    public List<TaskGeneralInfo> findTasks(Optional<Category> category) {
        List<Task> tasks = category.isPresent() ? taskRepository.findAllByCategory(category.get()) : taskRepository.findAll();
        return tasks.stream().map(Task::toTaskGeneralInfo).collect(Collectors.toList());
    }
}
