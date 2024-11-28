package tp.backend.reportes.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tp.backend.reportes.clases.Incidente;
import tp.backend.reportes.clases.Prueba;

@Service
public class ReporteService {

    // Método para obtener todos los incidentes
    public List<Incidente> obtenerIncidentes() {
        List<Incidente> incidentes = new ArrayList<>();
        // Simulación de datos
        incidentes.add(new Incidente(1L, "Accidente en la vía", LocalDate.now(), "ABC123", 101, 150.5));
        incidentes.add(new Incidente(2L, "Fallo de motor", LocalDate.now(), "DEF456", 102, 200.0));
        return incidentes;
    }

    // Método para obtener los incidentes de un empleado específico
    public List<Incidente> incidentesPorEmpleado(int empleadoId) {
        List<Incidente> incidentes = new ArrayList<>();
        // Simulación de datos
        if (empleadoId == 101) {
            incidentes.add(new Incidente(1L, "Accidente en la vía", LocalDate.now(), "ABC123", 101, 150.5));
        }
        return incidentes;
    }

    // Método para obtener los kilómetros recorridos por un vehículo en un período específico
    public double kilometrosPorVehiculoYPeriodo(String placa, LocalDate inicio, LocalDate fin) {
        // Lógica para calcular los kilómetros recorridos
        if ("ABC123".equals(placa)) {
            return 150.5; // Valor simulado
        }
        return 0.0;
    }

    // Método para obtener las pruebas realizadas para un vehículo
    public List<Prueba> pruebasPorVehiculo(String placa) {
        List<Prueba> pruebas = new ArrayList<>();
        // Simulación de datos
        if ("ABC123".equals(placa)) {
            pruebas.add(new Prueba(1L, "Prueba de frenos", "ABC123"));
        }
        return pruebas;
    }
}
