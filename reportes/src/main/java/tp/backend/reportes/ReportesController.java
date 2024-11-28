package tp.backend.reportes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tp.backend.reportes.clases.Incidente;
import tp.backend.reportes.clases.Prueba;

@RestController
@RequestMapping("/reportes")
public class ReportesController {

    private final ReporteService reporteService;

    public ReportesController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    // i. Obtener todos los incidentes
    @GetMapping("/incidentes")
    public List<Incidente> obtenerIncidentes() {
        return reporteService.obtenerIncidentes();
    }

    // ii. Detalle de incidentes para un empleado
    @GetMapping("/incidentes/empleado/{empleadoId}")
    public List<Incidente> incidentesPorEmpleado(@PathVariable int empleadoId) {
        return reporteService.incidentesPorEmpleado(empleadoId);
    }

    // iii. Cantidad de kilómetros recorridos por vehículo en un período
    @GetMapping("/kilometros")
    public double kilometrosPorVehiculoYPeriodo(
            @RequestParam String placa,
            @RequestParam String inicio,
            @RequestParam String fin) {
        return reporteService.kilometrosPorVehiculoYPeriodo(placa, LocalDate.parse(inicio), LocalDate.parse(fin));
    }

    // iv. Detalle de pruebas realizadas para un vehículo
    @GetMapping("/pruebas/vehiculo/{placa}")
    public List<Prueba> pruebasPorVehiculo(@PathVariable String placa) {
        return reporteService.pruebasPorVehiculo(placa);
    }
}
