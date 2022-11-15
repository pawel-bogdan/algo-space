package zpi.algospace.solution.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import zpi.algospace.model.ApplicationUser;
import zpi.algospace.model.Solution;
import zpi.algospace.model.dto.ApplicationUserDTO;
import zpi.algospace.repository.ApplicationUserRepository;
import zpi.algospace.service.ApplicationUserService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationUserServiceTest {
    @Mock
    ApplicationUserRepository applicationUserRepository;

    @InjectMocks
    ApplicationUserService uut;

    @Test
    void findSolutions() {
        //given
        String username = "testEmail";
        ApplicationUser user1 = ApplicationUser.builder().build();
        when(applicationUserRepository.findByUsername(username))
                .thenReturn(Optional.of(user1));

        //when
        List<Solution> result = uut.findSolutions(username);

        //then
        assertThat(result).isEqualTo(user1.getSolutions());
        assertThrows(
                IllegalArgumentException.class,
                () -> uut.findSolutions("")
        );
    }

    @ParameterizedTest
    @MethodSource
    void getUsersSortedByPoints(List<ApplicationUser> users, List<ApplicationUserDTO> usersDTO) {
        //given
        when(applicationUserRepository.findAll()).thenReturn(users);

        //when
        List<ApplicationUserDTO> result = uut.getUsersSortedByPoints();

        //then
        assertThat(result).isEqualTo(usersDTO);

    }

    private static Stream<Arguments> getUsersSortedByPoints() {
        ApplicationUser user1 = ApplicationUser.builder()
                .username("user1")
                .points(20)
                .password("kondi")
                .build();
        ApplicationUser user2 = ApplicationUser.builder()
                .username("user2")
                .points(80)
                .password("bandyta")
                .build();
        ApplicationUser user3 = ApplicationUser.builder()
                .username("user3")
                .points(30)
                .password("byczek")
                .build();

        return Stream.of(
                Arguments.of(List.of(user1, user2, user3), List.of(new ApplicationUserDTO(user2), new ApplicationUserDTO(user3), new ApplicationUserDTO(user1))),
                Arguments.of(Collections.emptyList(), Collections.emptyList())
        );
    }


}
