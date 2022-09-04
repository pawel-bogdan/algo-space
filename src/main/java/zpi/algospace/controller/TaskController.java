package zpi.algospace.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zpi.algospace.model.Category;
import zpi.algospace.model.Difficulty;
import zpi.algospace.model.dto.TaskGeneralInfo;
import zpi.algospace.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskGeneralInfo>> getTasks(@RequestParam(required = false) Category category,
                                                          @RequestParam(required = false) Difficulty difficulty) {
        log.info("Request got. /tasks with params: category: {} difficulty: {}", category, difficulty);
        return ResponseEntity.ok(taskService.findTasks(Optional.ofNullable(category)));
    }
}