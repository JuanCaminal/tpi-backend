package tp.backend.agencia.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.backend.agencia.models.Posicion;
import tp.backend.agencia.models.Prueba;
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

    private final PruebaService pruebaService;

    @GetMapping("{id_vehiculo}/{id_prueba}/posicion")
    public ResponseEntity<Posicion> getPosicionActual(@PathVariable Integer id_vehiculo, @PathVariable Integer id_prueba) {
        try {



            Posicion posicion = this.vehiculoService.getPosicionActual(id_vehiculo);

            Boolean esRiesgosa = this.esPosicionRiesgosa(posicion);

            if (esRiesgosa) {
            }

            return ResponseEntity.ok().body(posicion);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    private Boolean esPosicionRiesgosa(Posicion posicion) {
        //consumir API
        return false;
    }

}
