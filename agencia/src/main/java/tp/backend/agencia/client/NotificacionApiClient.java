package tp.backend.agencia.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tp.backend.agencia.config.FeignClientConfig;
import tp.backend.agencia.dto.NotificacionEmpleadoDto;

@FeignClient(name = "notificaccionApiClient", url = "http://localhost:8084/notificaciones/notificaciones", configuration = FeignClientConfig.class)
public interface NotificacionApiClient {

    @PostMapping("/empleado")
    ResponseEntity<Object> notificarEmpleado(@RequestBody NotificacionEmpleadoDto notificacion);

}
