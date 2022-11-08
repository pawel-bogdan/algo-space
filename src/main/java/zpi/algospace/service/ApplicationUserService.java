package zpi.algospace.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import zpi.algospace.model.ApplicationUser;
import zpi.algospace.model.Solution;
import zpi.algospace.model.dto.ApplicationUserRegistrationModel;
import zpi.algospace.repository.ApplicationUserRepository;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ApplicationUserService implements UserDetailsService {
    private final ApplicationUserRepository applicationUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username with given email: %s does not exist", username)));
    }

    public List<Solution> findSolutions(String userId) {
        ApplicationUser user = applicationUserRepository.findByEmail(userId).orElseThrow(() -> new IllegalArgumentException("User with given id does not exist"));
        return user.getSolutions();
    }

    public List<String> findEmailsAlreadyUsed() {
        return applicationUserRepository.findAll()
                .stream()
                .map(ApplicationUser::getEmail)
                .collect(toList());
    }

    public ApplicationUser createUser(ApplicationUserRegistrationModel userRegistrationModel) {
        if (isUserDataValid(userRegistrationModel)) {
            String encodedPassword = passwordEncoder.encode(userRegistrationModel.getPassword1());
            ApplicationUser user = ApplicationUser.builder()
                    .email(userRegistrationModel.getEmail())
                    .password(encodedPassword)
                    .enabled(true)
                    .points(0)
                    .solutions(new ArrayList<>())
                    .build();
            return applicationUserRepository.save(user);
        } else {
            throw new IllegalStateException("User data are invalid");
        }
    }

    private boolean isUserDataValid(ApplicationUserRegistrationModel userRegistrationModel) {
        boolean isEmailUsed = findEmailsAlreadyUsed().contains(userRegistrationModel.getEmail());
        boolean passwordsAreEqual = userRegistrationModel.getPassword1().equals(userRegistrationModel.getPassword2());
        return !isEmailUsed && passwordsAreEqual;
    }
}
