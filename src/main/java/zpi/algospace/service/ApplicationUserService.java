package zpi.algospace.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import zpi.algospace.model.ApplicationUser;
import zpi.algospace.model.Difficulty;
import zpi.algospace.model.Solution;
import zpi.algospace.model.dto.ApplicationUserDto;
import zpi.algospace.model.dto.ApplicationUserRegistrationModel;
import zpi.algospace.model.dto.SolutionPreviewModel;
import zpi.algospace.model.exception.SolutionNotFoundException;
import zpi.algospace.model.exception.UserAlreadyExistException;
import zpi.algospace.repository.ApplicationUserRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    private final static String USERNAME_NOT_FOUND_MSG = "Username: %s does not exist";
    private final static String USER_ALREADY_EXIST_MSG = "User with given username: %s exist.";
    private final static String SOLUTION_NOT_FOUND_MSG = "User with name: %s did not solve task with id: %s";
    private final ApplicationUserRepository applicationUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USERNAME_NOT_FOUND_MSG, username)));
    }

    public ApplicationUserDto findUser(String username) throws UsernameNotFoundException {
        return applicationUserRepository
                .findByUsername(username).map(ApplicationUserDto::new)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USERNAME_NOT_FOUND_MSG, username)));
    }

    public SolutionPreviewModel findSolution(Integer taskId, String username) throws UsernameNotFoundException, SolutionNotFoundException {
        List<SolutionPreviewModel> solutions = findSolutions(username);

        return solutions.stream()
                .filter(solution -> solution.getTaskGeneralInfo().getId() == taskId.longValue())
                .findFirst()
                .orElseThrow(
                        () -> new SolutionNotFoundException(String.format(SOLUTION_NOT_FOUND_MSG, username, taskId))
                );
    }

    public List<SolutionPreviewModel> findSolutions(String username) throws UsernameNotFoundException {
        ApplicationUser user = applicationUserRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USERNAME_NOT_FOUND_MSG, username)));
        return user.getSolutions().stream()
                .map(SolutionPreviewModel::new)
                .collect(toList());
    }

    public void createUser(ApplicationUserRegistrationModel userRegistrationModel) throws UserAlreadyExistException {
        if (!isUsernameAvailable(userRegistrationModel.getUsername())) {
            throw new UserAlreadyExistException(String.format(USER_ALREADY_EXIST_MSG, userRegistrationModel));
        }

        if (isUserDataValid(userRegistrationModel)) {
            String encodedPassword = passwordEncoder.encode(userRegistrationModel.getPassword1());
            ApplicationUser user = ApplicationUser.builder()
                    .username(userRegistrationModel.getUsername())
                    .password(encodedPassword)
                    .enabled(true)
                    .points(0)
                    .solutions(new ArrayList<>())
                    .build();
            applicationUserRepository.save(user);
        } else {
            throw new IllegalStateException("User data are invalid");
        }
    }

    public List<ApplicationUserDto> getUsersSortedByPoints() {
        return applicationUserRepository.findAll().stream()
                .map(ApplicationUserDto::new)
                .sorted(Comparator.comparingInt(ApplicationUserDto::getPoints).reversed())
                .collect(toList());
    }

    public boolean isUsernameAvailable(String username) {
        return !findUsernamesAlreadyUsed().contains(username);
    }

    public void assign(Solution solution) {
        String solverUsername = solution.getSolver().getUsername();
        applicationUserRepository.addPoints(solverUsername, getPoints(solution.getTask().getDifficulty()));
    }

    private boolean isUserDataValid(ApplicationUserRegistrationModel userRegistrationModel) {
        boolean isUsernameUsed = !isUsernameAvailable(userRegistrationModel.getUsername());
        boolean passwordsAreEqual = userRegistrationModel.getPassword1().equals(userRegistrationModel.getPassword2());
        return !isUsernameUsed && passwordsAreEqual;
    }

    private Set<String> findUsernamesAlreadyUsed() {
        return applicationUserRepository.findAll()
                .stream()
                .map(ApplicationUser::getUsername)
                .collect(Collectors.toSet());
    }

    private int getPoints(Difficulty difficulty) {
        int points = 0;
        switch (difficulty) {
            case EASY -> points = 50;
            case MEDIUM -> points = 150;
            case HARD -> points = 250;
        }
        return points;
    }
}
