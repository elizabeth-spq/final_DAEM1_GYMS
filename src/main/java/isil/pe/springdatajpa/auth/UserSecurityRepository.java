package isil.pe.springdatajpa.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSecurityRepository extends JpaRepository<UserSecurity, Long> {
  Optional<UserSecurity> findUserSecurityByEmailAndPassword(String email, String password);
  Optional<UserSecurity> findUserByEmail(String email);


}
