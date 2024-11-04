package tp.backend.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.backend.agencia.models.Posicion;

public interface PosicionRepository extends JpaRepository<Posicion, Integer> {
}
