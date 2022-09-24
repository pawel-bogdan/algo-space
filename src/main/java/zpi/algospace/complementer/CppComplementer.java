package zpi.algospace.complementer;

import lombok.AllArgsConstructor;
import org.webjars.NotFoundException;
import zpi.algospace.model.Language;
import zpi.algospace.model.Task;
import zpi.algospace.model.Test;
import zpi.algospace.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CppComplementer implements Complementary {
    private static final String IMPORTS = "#include <bits/stdc++.h>\nusing namespace std;";
    private static final String CLASS_CORE = "int main() { %s } %s }";
    private Long taskId;
    private TaskRepository taskRepository;

    @Override
    public String complement(String solution) {
        return IMPORTS + String.format(CLASS_CORE, this.prepareTests(taskId), solution);
    }

    @Override
    public String prepareTests(Long taskId) {
        Optional<Task> taskToTest = taskRepository.findById(taskId);
        List<String> tests;
        if(taskToTest.isPresent())
            tests = taskToTest.get()
                    .getTests()
                    .stream()
                    .filter(t -> t.getLanguage() == Language.CPP)
                    .map(Test::getContent)
                    .collect(Collectors.toList());
        else
            throw new NotFoundException("Task not found");
        return String.join( "\n", tests);
    }
}
