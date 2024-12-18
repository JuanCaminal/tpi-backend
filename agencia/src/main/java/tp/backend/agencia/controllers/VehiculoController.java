package tp.backend.agencia.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.backend.agencia.client.NotificacionApiClient;
import tp.backend.agencia.dto.NotificacionEmpleadoDto;
import tp.backend.agencia.models.Empleado;
import tp.backend.agencia.models.Posicion;
import tp.backend.agencia.models.Prueba;
import tp.backend.agencia.models.Vehiculo;
import tp.backend.agencia.services.interfaces.InteresadoService;
import tp.backend.agencia.services.interfaces.PosicionService;
import tp.backend.agencia.services.interfaces.PruebaService;
import tp.backend.agencia.services.interfaces.VehiculoService;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {
    private final VehiculoService vehiculoService;

    private final PosicionService posicionService;

    private final InteresadoService interesadoService;

    private final NotificacionApiClient notificacionApiClient;

    @GetMapping("{id_vehiculo}/posicion")
    public ResponseEntity<Posicion> getPosicionActual(@PathVariable Integer id_vehiculo) {
        try {
            //obtener vehiculo acaaa

            Vehiculo vehiculo = this.vehiculoService.findById(id_vehiculo);

            Prueba pruebaEnCurso = vehiculo.getPruebaEnCurso();

            Posicion posicionActual = vehiculo.getPosicionActual();

            if (pruebaEnCurso != null && posicionActual != null) {
                Posicion posicionPeligroObtenido = this.posicionService.verificarZonaPeligrosa(posicionActual);

                if (posicionPeligroObtenido != null && posicionPeligroObtenido.getEsRiesgosa()) {

                    this.interesadoService.restringirInteresado(pruebaEnCurso.getInteresado());

                    this.enviarNotificacionEmpleado(null);
                }

            }


            return ResponseEntity.ok().body(posicionActual);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Object> enviarNotificacionEmpleado(NotificacionEmpleadoDto notificacionEmpleadoDto) {
        //mandarle notificacion al empleado a cargo de la prueba
        return notificacionApiClient.notificarEmpleado(notificacionEmpleadoDto);

    }


}
