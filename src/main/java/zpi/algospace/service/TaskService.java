package zpi.algospace.service;

import org.springframework.stereotype.Service;
import zpi.algospace.model.Category;
import zpi.algospace.model.Difficulty;
import zpi.algospace.model.Task;
import zpi.algospace.model.dto.TaskDTO;
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

    public List<TaskGeneralInfo> findTasks(Category category, Difficulty difficulty) {
        List<Task> tasks;
        if(category == null && difficulty == null) {
            tasks = taskRepository.findAll();
        } else if (category == null && difficulty != null) {
            tasks = taskRepository.findAllByDifficulty(difficulty);
        } else if (category != null && difficulty == null) {
            tasks = taskRepository.findAllByCategory(category);
        } else {
            tasks = taskRepository.findAllByCategoryAndAndDifficulty(category, difficulty);
        }
        return tasks.stream().map(Task::toTaskGeneralInfo).collect(Collectors.toList());
    }

    public Optional<Task> findTask(Long id) {
        return taskRepository.findById(id);
    }
}
