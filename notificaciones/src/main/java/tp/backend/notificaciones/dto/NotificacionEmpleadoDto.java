package tp.backend.notificaciones.dto;

import lombok.Data;
import tp.backend.notificaciones.constants.MedioNotificacion;
import tp.backend.notificaciones.models.Empleado;

@Data
public class NotificacionEmpleadoDto {
    private String mensaje;
    private MedioNotificacion medio;
    private Empleado empleado;
}
