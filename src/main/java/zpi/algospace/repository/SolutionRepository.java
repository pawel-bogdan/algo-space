package zpi.algospace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zpi.algospace.model.Solution;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Long> {
}
