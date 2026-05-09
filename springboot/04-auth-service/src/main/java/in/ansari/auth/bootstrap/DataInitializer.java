package in.ansari.auth.bootstrap;

import in.ansari.auth.entity.User;
import in.ansari.auth.enums.Role;
import in.ansari.auth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        boolean exists = userRepository
                .existsByTenantIdAndUsernameAndIsDeletedFalse(1L, "admin");

        if (!exists) {
            User admin = new User();
            admin.setTenantId(1L);
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(Role.ADMIN);
            admin.setIsDeleted(false);

            userRepository.save(admin);
        }
    }
}