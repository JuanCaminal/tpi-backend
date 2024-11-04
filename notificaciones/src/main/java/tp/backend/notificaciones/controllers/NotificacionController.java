package tp.backend.notificaciones.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.backend.notificaciones.dto.PublicidadDto;
import tp.backend.notificaciones.models.Destinatario;
import tp.backend.notificaciones.models.NotificacionPublicidad;
import tp.backend.notificaciones.services.interfaces.NotificacionEmpleadoService;
import tp.backend.notificaciones.services.interfaces.NotificacionPublicidadService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/notificaciones")
@RequiredArgsConstructor
public class NotificacionController {

    private final NotificacionEmpleadoService notificacionEmpleadoService;
    private final NotificacionPublicidadService notificacionPublicidadService;

    @PostMapping("/promociones")
    public ResponseEntity<Object> enviarPromociones(@RequestBody PublicidadDto publicidadDto) {
        try {

            NotificacionPublicidad nuevaNotificacion = new NotificacionPublicidad();
            nuevaNotificacion.setMensaje(publicidadDto.getMensaje());
            nuevaNotificacion.setMedio(publicidadDto.getMedio());
            nuevaNotificacion.setDestinatarios(publicidadDto.getDestinatarios());

            NotificacionPublicidad nuevaNotificacionPublicidad = this.notificacionPublicidadService.create(nuevaNotificacion);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNotificacionPublicidad.getId());

        } catch (IllegalArgumentException e) {
            // Devuelve 400 para errores de validación
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
