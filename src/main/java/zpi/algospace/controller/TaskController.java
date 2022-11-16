package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.Category;
import zpi.algospace.model.Difficulty;
import zpi.algospace.model.dto.TaskDTO;
import zpi.algospace.model.dto.TaskGeneralInfo;
import zpi.algospace.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Task Controller")
@RequestMapping({"/", "/api"})
@Slf4j
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/tasks")
    @Operation(summary = "Get all tasks from database.")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<List<TaskGeneralInfo>> getTasks(
            @RequestParam(required = false) Category category,
            @RequestParam(required = false) Difficulty difficulty) {
        log.info(" >>> Request got. /tasks with params: category: {} difficulty: {}", category, difficulty);
        List<TaskGeneralInfo> tasks = taskService.findTasks(category, difficulty);
        log.info(" >>> Returned response with data: {}", tasks);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/tasks/{id}")
    @Operation(summary = "Get task with given id from database.")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<TaskDTO> getTask(@PathVariable Long id) {
        log.info(" >>> Request got. /tasks/{}", id);
        try {
            TaskDTO task = taskService.findTask(id);
            log.info(" >>> Returned response with data: {}", task);
            return ResponseEntity.ok(task);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tasks/number")
    @Operation(summary = "Return number of tasks from database.")
    public ResponseEntity<Integer> getNumberOfTasks() {
        log.info(" >>> Request got. /tasks/number");
        int result = taskService.countAllTasks();
        log.info(" >>> Returned number of tasks: {}", result);
        return ResponseEntity.ok(result);
    }

}
