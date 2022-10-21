package zpi.algospace.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zpi.algospace.model.Solution;
import zpi.algospace.model.User;
import zpi.algospace.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<Solution> findSolutions(String userId) {
        User user = userRepository.findByEmail(userId).orElseThrow(() -> new IllegalArgumentException("User with given id does not exist"));
        return user.getSolutions();
    }
}
