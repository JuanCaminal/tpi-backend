package tp.backend.reportes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.backend.reportes.clases.Incidente;

public interface IncidenteRepository extends JpaRepository<Incidente, Long> {

    // Buscar incidentes por empleadoId
    List<Incidente> findByEmpleadoId(int empleadoId);

    // Aquí puedes agregar más consultas personalizadas si es necesario
}
