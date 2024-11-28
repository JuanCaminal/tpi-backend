package tp.backend.reportes.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tp.backend.reportes.models.Prueba;
import tp.backend.reportes.services.ReporteServiceImpl;

@RestController
@RequestMapping("/reportes")
@RequiredArgsConstructor
@EnableFeignClients
public class ReportesController {

    private final ReporteServiceImpl reporteService;


    // 1- Obtener todos los incidentes
    @GetMapping("/incidentes")
    public List<Prueba> obtenerIncidentes() {
        return reporteService.obtenerIncidentes();
    }

    // 2- Detalle de incidentes para un empleado
    @GetMapping("/incidentes/empleado/{empleadoId}")
    public List<Prueba> incidentesPorEmpleado(@PathVariable int empleadoId) {
        return reporteService.incidentesPorEmpleado(empleadoId);
    }

    // 3- Cantidad de kilómetros recorridos por vehículo en un período
    @GetMapping("/kilometros")
    public double kilometrosPorVehiculoYPeriodo(
            @RequestParam String patente,
            @RequestParam String inicio,
            @RequestParam String fin) {
        return reporteService.kilometrosPorVehiculoYPeriodo(patente, LocalDate.parse(inicio), LocalDate.parse(fin));
    }

    // 4- Detalle de pruebas realizadas para un vehículo
    @GetMapping("/pruebas/vehiculo/{patente}")
    public List<Prueba> pruebasPorVehiculo(@PathVariable String patente) {
        return reporteService.pruebasPorVehiculo(patente);
    }
}
