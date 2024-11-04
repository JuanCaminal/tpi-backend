package tp.backend.notificaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.backend.notificaciones.models.NotificacionEmpleado;

public interface NotificacionEmpleadoRepository extends JpaRepository<NotificacionEmpleado, Integer> {
}
