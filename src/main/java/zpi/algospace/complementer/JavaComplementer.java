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
public class JavaComplementer implements Complementary {
    private static final String IMPORTS = "import java.util.*; import java.lang.Math.*;";
    private static final String CLASS_CORE = "public class %s { public static void main(String[] args) { %s } %s }";
    private String className;
    private Long taskId;
    private TaskRepository taskRepository;

    @Override
    public String complement(String solutionContent) {
        return IMPORTS + String.format(CLASS_CORE, className, this.prepareTests(taskId), solutionContent);
    }

    @Override
    public String prepareTests(Long taskId) {
        Optional<Task> taskToTest = taskRepository.findById(taskId);
        List<String> tests;
        if(taskToTest.isPresent())
            tests = taskToTest.get()
                    .getTests()
                    .stream()
                    .filter(t -> t.getLanguage() == Language.JAVA)
                    .map(Test::getContent)
                    .collect(Collectors.toList());
        else
            throw new NotFoundException("Task not found");
        return String.join( "\n", tests);
    }
}
