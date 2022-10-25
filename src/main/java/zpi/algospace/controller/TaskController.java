package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.Category;
import zpi.algospace.model.Difficulty;
import zpi.algospace.model.Language;
import zpi.algospace.model.Template;
import zpi.algospace.model.dto.TaskDTO;
import zpi.algospace.model.dto.TaskGeneralInfo;
import zpi.algospace.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Task Controller")
@RequestMapping({"/", "/api"})
@CrossOrigin(origins = {"${allowed.origin}"})
@Slf4j
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/tasks")
    @Operation(summary = "Get all tasks from database.")
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

    @GetMapping("/tasks/{id}/template")
    @Operation(summary = "Get solution template for given task in given language ")
    public ResponseEntity<Template> getSolutionTemplate(
            @PathVariable Long id,
            @RequestParam Language language) {
        log.info(" >>> Request got. /tasks/{}/template", id);
        try {
            Template template = taskService.findTemplate(id, language);
            log.info(" >>> Returned response with data: {}", template);
            return ResponseEntity.ok(template);
        } catch (IllegalArgumentException e){
            log.error(e.getMessage(), e);
            return ResponseEntity.notFound().build();
        }
    }
}
