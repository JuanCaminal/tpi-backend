package tp.backend.agencia.dto;

import lombok.Data;
import tp.backend.agencia.models.Empleado;
import tp.backend.notificaciones.constants.MedioNotificacion;


@Data
public class NotificacionEmpleadoDto {
    private String mensaje;
    private MedioNotificacion medio;
    private Empleado empleado;
}
