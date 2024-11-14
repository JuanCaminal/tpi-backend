package tp.backend.agencia.dto;

import lombok.Data;
import tp.backend.agencia.models.Empleado;


@Data
public class NotificacionEmpleadoDto {
    private String mensaje;
    private String medio;
    private Empleado empleado;
}
