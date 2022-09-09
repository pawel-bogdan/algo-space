package zpi.algospace.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.Category;
import zpi.algospace.model.Difficulty;
import zpi.algospace.model.Task;
import zpi.algospace.model.dto.TaskDTO;
import zpi.algospace.model.dto.TaskGeneralInfo;
import zpi.algospace.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping({"/", "/api"})
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskGeneralInfo>> getTasks(@RequestParam(required = false) Category category,
                                                          @RequestParam(required = false) Difficulty difficulty) {
        log.info(" >>> Request got. /tasks with params: category: {} difficulty: {}", category, difficulty);
        List<TaskGeneralInfo> tasks = taskService.findTasks(category, difficulty);
        log.info(" >>> Returned response with data: {}", tasks);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable Long id) {
        log.info(" >>> Request got. /tasks/{}", id);
        Optional<Task> task = taskService.findTask(id);
        if (task.isPresent()) {
            log.info(" >>> Returned response with data: {}", task.get());
            return ResponseEntity.ok(new TaskDTO(task.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}