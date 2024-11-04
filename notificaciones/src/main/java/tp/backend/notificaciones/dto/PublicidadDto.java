package tp.backend.notificaciones.dto;

import lombok.Data;
import tp.backend.notificaciones.constants.MedioNotificacion;
import tp.backend.notificaciones.models.Destinatario;

import java.util.List;

@Data
public class PublicidadDto {
    private String mensaje;
    private MedioNotificacion medio;
    private List<Destinatario> destinatarios;
}
