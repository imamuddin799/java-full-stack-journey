package in.ansari.auth.repository;

import in.ansari.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByTenantIdAndUsernameAndIsDeletedFalse(
            Long tenantId,
            String username
    );

    boolean existsByTenantIdAndUsernameAndIsDeletedFalse(
            Long tenantId,
            String username
    );
}