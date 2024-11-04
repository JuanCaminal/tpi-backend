package tp.backend.agencia.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.backend.agencia.dto.FinalizarPruebaDto;
import tp.backend.agencia.models.Prueba;
import tp.backend.agencia.services.interfaces.PruebaService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/pruebas")
@RequiredArgsConstructor
public class PruebaController {

    private final PruebaService pruebaService;


    // 1
    @PostMapping("/generar-prueba")
    public ResponseEntity<Object> generarPrueba(@RequestBody Prueba prueba) {
        try {
            Prueba nuevaPrueba = this.pruebaService.create(prueba);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPrueba.getId());

        } catch (IllegalArgumentException e) {
            // Devuelve 400 para errores de validación
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 2
    @GetMapping("/en-curso")
    public ResponseEntity<List<Prueba>> getPruebasEnCurso() {
        try {
            List<Prueba> result = this.pruebaService.getPruebasEnCurso();
            return ResponseEntity.ok(result);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("{id_prueba}/finalizar")
    public ResponseEntity<Object> finalizarPrueba(@PathVariable Integer id_prueba, @RequestBody FinalizarPruebaDto request) {
        String comentario = request.getComentario();
        try {
            this.pruebaService.finalizarPrueba(id_prueba, comentario);
            return ResponseEntity.ok("Prueba finalizada con éxito");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
