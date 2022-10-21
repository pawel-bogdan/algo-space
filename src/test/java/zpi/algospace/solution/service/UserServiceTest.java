package zpi.algospace.solution.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import zpi.algospace.service.UserService;
import zpi.algospace.model.Solution;
import zpi.algospace.model.User;
import zpi.algospace.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void findSolutions() {
        //given
        String userEmail = "testEmail";
        User user1 = User.builder().build();
        Mockito.when(userRepository.findByEmail(userEmail))
                .thenReturn(Optional.of(user1));

        //when
        List<Solution> expectSolutions = userService.findSolutions(userEmail);

        //then
        assertThat(expectSolutions).isEqualTo(user1.getSolutions());
        assertThrows(
                IllegalArgumentException.class,
                () -> userService.findSolutions("")
        );
    }
}
