package zpi.algospace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zpi.algospace.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
