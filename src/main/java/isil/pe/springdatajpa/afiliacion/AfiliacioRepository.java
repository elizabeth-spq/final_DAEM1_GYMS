package isil.pe.springdatajpa.afiliacion;

import isil.pe.springdatajpa.auth.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AfiliacioRepository extends JpaRepository<Afiliacio, Long> {
    Optional<Afiliacio> findAfiliacioByDni(String dni);
}
