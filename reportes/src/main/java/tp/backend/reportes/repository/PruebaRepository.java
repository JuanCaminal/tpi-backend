package tp.backend.reportes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tp.backend.reportes.models.Prueba;

public interface PruebaRepository extends JpaRepository<Prueba, Long> {

    // Find pruebas where tuvoIncidentes is true
    @Query("SELECT p FROM Prueba p WHERE p.tuvoIncidentes = true")
    List<Prueba> findAllIncidentes();

    // Find pruebas where tuvoIncidentes is true for a specific empleado
    @Query("SELECT p FROM Prueba p WHERE p.tuvoIncidentes = true AND p.empleado.id = :empleadoId")
    List<Prueba> findIncidenteByEmpleadoId(int empleadoId);

    // Find pruebas for a specific vehiculo
    @Query("SELECT p FROM Prueba p WHERE p.vehiculo.patente = :patente")
    List<Prueba> findByVehiculoPatente(String patente);

}
