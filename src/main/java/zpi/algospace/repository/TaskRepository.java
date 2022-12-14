package zpi.algospace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zpi.algospace.model.Category;
import zpi.algospace.model.Difficulty;
import zpi.algospace.model.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByCategory(Category category);

    List<Task> findAllByDifficulty(Difficulty difficulty);

    List<Task> findAllByCategoryAndDifficulty(Category category, Difficulty difficulty);
}
