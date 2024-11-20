package tp.backend.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.backend.agencia.models.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    // You can define custom queries here if needed
    // For example: List<Empleado> findByApellido(String apellido);
}
