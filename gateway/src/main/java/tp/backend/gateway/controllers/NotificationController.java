package tp.backend.gateway.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tp.backend.gateway.dto.NotificacionEmpleadoDto;
import tp.backend.gateway.dto.PublicidadDto;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final RestTemplate restTemplate;

    // URL del microservicio de notificaciones
    private static final String NOTIFICATIONS_SERVICE_URL = "http://notification-service/notificaciones";

    // Endpoint para enviar notificación de promociones (publicidad)
    @PostMapping("/promociones")
    public ResponseEntity<Object> sendPromotionsNotification(@RequestBody PublicidadDto publicidadDto) {
        String url = NOTIFICATIONS_SERVICE_URL + "/promociones";

        // Se realiza la solicitud POST hacia el microservicio
        ResponseEntity<Object> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(publicidadDto), // Pasamos el cuerpo de la solicitud
                Object.class
        );

        return response; // Se devuelve la respuesta del microservicio
    }

    // Endpoint para enviar notificación de empleados
    @PostMapping("/empleado")
    public ResponseEntity<Object> sendEmployeeNotification(@RequestBody NotificacionEmpleadoDto notificacionEmpleadoDto) {
        String url = NOTIFICATIONS_SERVICE_URL + "/empleado";

        // Se realiza la solicitud POST hacia el microservicio
        ResponseEntity<Object> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(notificacionEmpleadoDto), // Pasamos el cuerpo de la solicitud
                Object.class
        );

        return response; // Se devuelve la respuesta del microservicio
    }
}