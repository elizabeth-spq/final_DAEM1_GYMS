package isil.pe.springdatajpa.visittas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisittasRepository extends JpaRepository<Visittas, Long> {

  Optional<Visittas> findVisittaByDni(String dni);


}
