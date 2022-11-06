package zpi.algospace.solution.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import zpi.algospace.service.ApplicationUserService;
import zpi.algospace.model.Solution;
import zpi.algospace.model.ApplicationUser;
import zpi.algospace.repository.ApplicationUserRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ApplicationUserServiceTest {
    @Mock
    ApplicationUserRepository applicationUserRepository;

    @InjectMocks
    ApplicationUserService applicationUserService;

    @Test
    void findSolutions() {
        //given
        String userEmail = "testEmail";
        ApplicationUser user1 = ApplicationUser.builder().build();
        Mockito.when(applicationUserRepository.findByEmail(userEmail))
                .thenReturn(Optional.of(user1));

        //when
        List<Solution> result = applicationUserService.findSolutions(userEmail);

        //then
        assertThat(result).isEqualTo(user1.getSolutions());
        assertThrows(
                IllegalArgumentException.class,
                () -> applicationUserService.findSolutions("")
        );
    }
}
