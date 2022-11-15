package zpi.algospace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zpi.algospace.model.ApplicationUser;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByUsername(String username);

    @Transactional
    @Modifying
    @Query("update ApplicationUser u set u.points = u.points + ?2 where u.username = ?1")
    int addPoints(@Param("username") String username, @Param("points") Integer points);
}
