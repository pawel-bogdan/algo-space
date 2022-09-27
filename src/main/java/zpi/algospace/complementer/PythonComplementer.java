package zpi.algospace.complementer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.webjars.NotFoundException;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;
import zpi.algospace.model.Task;
import zpi.algospace.model.Test;
import zpi.algospace.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
public class PythonComplementer implements Complementary {
    private static final String IMPORTS = "import numpy as np\n";
    private static final String CLASS_CORE = "if __name__ == \"__main__\":\n\t%s\n\n%s";
    private Long taskId;
    private TaskRepository taskRepository;
    private String className;

    @Override
    public void complement(Solution solution) {
        solution.setComplementedContent(IMPORTS + String.format(CLASS_CORE, className, solution.getContent()));
        //return IMPORTS + String.format(CLASS_CORE, this.prepareTests(taskId), solution);
    }

    /*public String prepareTests(Long taskId) {
        Optional<Task> taskToTest = taskRepository.findById(taskId);
        List<String> tests;
        if(taskToTest.isPresent())
            tests = taskToTest.get()
                    .getTests()
                    .stream()
                    .filter(t -> t.getLanguage() == Language.PYTHON)
                    .map(Test::getContent)
                    .collect(Collectors.toList());
        else
            throw new NotFoundException("Task not found");
        return String.join( "\n", tests);
    }*/
}
