package tp.backend.notificaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.backend.notificaciones.models.NotificacionPublicidad;

public interface NotificacionPublicidadRepository extends JpaRepository<NotificacionPublicidad, Integer> {
}
