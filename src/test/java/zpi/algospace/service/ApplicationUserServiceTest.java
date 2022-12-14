package zpi.algospace.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import zpi.algospace.model.*;
import zpi.algospace.model.dto.ApplicationUserDto;
import zpi.algospace.model.dto.SolutionPreviewModel;
import zpi.algospace.model.exception.SolutionNotFoundException;
import zpi.algospace.repository.ApplicationUserRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationUserServiceTest {
    private static final String DUMMY_USERNAME = "someUser";
    @Mock
    private ApplicationUserRepository applicationUserRepository;
    @InjectMocks
    private ApplicationUserService uut;

    @Test
    void findUserWhenUserExistsShouldFindUserAndConvertToDtoModel() {
        //given
        ApplicationUser dummyUser = ApplicationUser.builder()
                .username(DUMMY_USERNAME)
                .points(1337)
                .build();

        when(applicationUserRepository.findByUsername(DUMMY_USERNAME))
                .thenReturn(Optional.ofNullable(dummyUser));
        //when
        ApplicationUserDto result = uut.findUser(DUMMY_USERNAME);

        //then
        assertThat(result).isEqualTo(new ApplicationUserDto(DUMMY_USERNAME, 1337));
    }

    @Test
    void findUserWhenUserDoesNotExistShouldThrowAnUsernameNotFoundException() {
        //given
        when(applicationUserRepository.findByUsername(DUMMY_USERNAME))
                .thenReturn(Optional.empty());

        //then
        UsernameNotFoundException thrown =
                assertThrows(UsernameNotFoundException.class, () -> uut.findUser(DUMMY_USERNAME));
        assertThat(thrown.getMessage()).isEqualTo("Username: " + DUMMY_USERNAME + " does not exist");
    }

    @Test
    void findSolutionsWhenUserHasCorrectSolutionsShouldFindSolutionsOfGivenUser() {
        //given
        ApplicationUser dummyUser = ApplicationUser.builder()
                .username(DUMMY_USERNAME)
                .build();

        Solution s1 = Solution.builder()
                .id(4L)
                .submissionDate(LocalDateTime.now())
                .task(Task.builder()
                        .category(Category.ARRAYS)
                        .difficulty(Difficulty.MEDIUM).build())
                .solver(dummyUser)
                .language(Language.JAVA)
                .build();
        Solution s2 = Solution.builder()
                .id(8L)
                .submissionDate(LocalDateTime.now())
                .task(Task.builder()
                        .category(Category.ARRAYS)
                        .difficulty(Difficulty.MEDIUM)
                        .build())
                .solver(dummyUser)
                .language(Language.JAVA)
                .build();

        dummyUser.setSolutions(List.of(s1, s2));

        when(applicationUserRepository.findByUsername(DUMMY_USERNAME))
                .thenReturn(Optional.of(dummyUser));

        //when
        List<SolutionPreviewModel> result = uut.findSolutions(DUMMY_USERNAME);

        //then
        assertThat(result).isEqualTo(Stream.of(s1, s2).map(SolutionPreviewModel::new).collect(toList()));
    }

    @Test
    void findSolutionsWhenUserDoesNotHaveCorrectSolutionsShouldReturnEmptyList() {
        //given
        ApplicationUser dummyUser = ApplicationUser.builder()
                .username(DUMMY_USERNAME)
                .solutions(Collections.emptyList())
                .build();
        when(applicationUserRepository.findByUsername(DUMMY_USERNAME))
                .thenReturn(Optional.of(dummyUser));

        //when
        List<SolutionPreviewModel> result = uut.findSolutions(DUMMY_USERNAME);

        //then
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void findSolutionsForUserWhoDoesNotExistShouldThrowAnUsernameNotFoundException() {
        //given
        when(applicationUserRepository.findByUsername(DUMMY_USERNAME))
                .thenReturn(Optional.empty());

        //then
        UsernameNotFoundException thrown = assertThrows(UsernameNotFoundException.class,
                () -> uut.findSolutions(DUMMY_USERNAME));
        assertThat(thrown.getMessage()).isEqualTo("Username: " + DUMMY_USERNAME + " does not exist");
    }

    @Test
    @SneakyThrows
    void findSolutionWhenUserExistAndHasCorrectSolutionForThisTaskShouldReturnSolution() {
        ApplicationUser dummyUser = ApplicationUser.builder()
                .username(DUMMY_USERNAME)
                .build();

        Solution s1 = Solution.builder()
                .id(4L)
                .submissionDate(LocalDateTime.now())
                .content("content1")
                .task(Task.builder()
                        .id(1L)
                        .category(Category.ARRAYS)
                        .difficulty(Difficulty.MEDIUM)
                        .build()
                )
                .solver(dummyUser)
                .language(Language.JAVA)
                .build();

        Solution s2 = Solution.builder()
                .id(8L)
                .submissionDate(LocalDateTime.now())
                .content("content2")
                .task(Task.builder()
                        .id(2L)
                        .category(Category.ARRAYS)
                        .difficulty(Difficulty.MEDIUM)
                        .build()
                )
                .solver(dummyUser)
                .language(Language.JAVA)
                .build();

        dummyUser.setSolutions(List.of(s1, s2));

        when(applicationUserRepository.findByUsername(DUMMY_USERNAME))
                .thenReturn(Optional.of(dummyUser));

        //when
        SolutionPreviewModel result = uut.findSolution(1, DUMMY_USERNAME);

        //then
        SolutionPreviewModel expectedResult = new SolutionPreviewModel(s1);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @SneakyThrows
    void findSolutionWhenUserExistAndDoesNotHaveCorrectSolutionForThisTaskShouldThrowSolutionNotFoundException() {
        ApplicationUser dummyUser = ApplicationUser.builder()
                .username(DUMMY_USERNAME)
                .build();

        Solution s1 = Solution.builder()
                .id(4L)
                .submissionDate(LocalDateTime.now())
                .content("content1")
                .task(Task.builder()
                        .id(1L)
                        .category(Category.ARRAYS)
                        .difficulty(Difficulty.MEDIUM)
                        .build()
                )
                .solver(dummyUser)
                .language(Language.JAVA)
                .build();

        Solution s2 = Solution.builder()
                .id(8L)
                .submissionDate(LocalDateTime.now())
                .content("content2")
                .task(Task.builder()
                        .id(2L)
                        .category(Category.ARRAYS)
                        .difficulty(Difficulty.MEDIUM)
                        .build()
                )
                .solver(dummyUser)
                .language(Language.JAVA)
                .build();

        dummyUser.setSolutions(List.of(s1, s2));

        when(applicationUserRepository.findByUsername(DUMMY_USERNAME))
                .thenReturn(Optional.of(dummyUser));

        //then
        var thrown = assertThrows(SolutionNotFoundException.class,
                () -> uut.findSolution(-23, DUMMY_USERNAME));
        assertThat(thrown.getMessage()).isEqualTo("User with name: " + DUMMY_USERNAME + " did not solve task with id: -23");
    }

    @Test
    @SneakyThrows
    void findSolutionWhenUserDoesNotExistShouldThrowUsernameNotFoundException() {
        //given
        when(applicationUserRepository.findByUsername(DUMMY_USERNAME)).thenReturn(Optional.empty());

        //then
        var thrown = assertThrows(UsernameNotFoundException.class,
                () -> uut.findSolution(1, DUMMY_USERNAME));
        assertThat(thrown.getMessage()).isEqualTo("Username: " + DUMMY_USERNAME + " does not exist");
    }

    @ParameterizedTest
    @MethodSource
    void isUsernameAvailable(List<ApplicationUser> users, boolean result) {
        //given
        when(applicationUserRepository.findAll()).thenReturn(users);

        //then
        assertThat(uut.isUsernameAvailable(DUMMY_USERNAME)).isEqualTo(result);
    }

    private static Stream<Arguments> isUsernameAvailable() {
        var kien = ApplicationUser.builder().username("Kien").build();
        var hades222 = ApplicationUser.builder().username("hades222").build();
        var killer1337 = ApplicationUser.builder().username("killer1337").build();
        var someUser = ApplicationUser.builder().username("someUser").build();

        return Stream.of(
                Arguments.of(List.of(kien, hades222, killer1337), true),
                Arguments.of(List.of(kien, killer1337, someUser), false),
                Arguments.of(List.of(), true)
        );
    }

    @ParameterizedTest
    @MethodSource
    void getUsersSortedByPoints(List<ApplicationUser> users, List<ApplicationUserDto> usersDTO) {
        //given
        when(applicationUserRepository.findAll()).thenReturn(users);

        //when
        List<ApplicationUserDto> result = uut.getUsersSortedByPoints();

        //then
        assertThat(result).isEqualTo(usersDTO);

    }

    private static Stream<Arguments> getUsersSortedByPoints() {
        ApplicationUser dummyUser1 = ApplicationUser.builder()
                .username("user1")
                .points(20)
                .password("kondi")
                .build();
        ApplicationUser dummyUser2 = ApplicationUser.builder()
                .username("user2")
                .points(80)
                .password("bandyta")
                .build();
        ApplicationUser dummyUser3 = ApplicationUser.builder()
                .username("user3")
                .points(30)
                .password("byczek")
                .build();

        return Stream.of(
                Arguments.of(List.of(dummyUser1, dummyUser2, dummyUser3), List.of(new ApplicationUserDto(dummyUser2), new ApplicationUserDto(dummyUser3), new ApplicationUserDto(dummyUser1))),
                Arguments.of(Collections.emptyList(), Collections.emptyList())
        );
    }


}
