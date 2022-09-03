package zpi.algospace.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zpi.algospace.Category;
import zpi.algospace.models.Difficulty;
import zpi.algospace.models.dto.TaskGeneralInfo;
import zpi.algospace.services.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskGeneralInfo>> getTasks(@RequestParam(required = false) Category category,
                                                          @RequestParam(required = false) Difficulty difficulty) {
        log.info("Request got. /tasks with params: category: {} difficulty: {}", category, difficulty);
        return ResponseEntity.ok(taskService.findTasks(Optional.ofNullable(category)));
    }
}
