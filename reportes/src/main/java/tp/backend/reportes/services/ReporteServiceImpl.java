package tp.backend.reportes.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tp.backend.reportes.models.Prueba;
import tp.backend.reportes.repository.PruebaRepository;

@Service
@RequiredArgsConstructor
public class ReporteServiceImpl extends ServiceImpl<Prueba, Integer>{

    private final PruebaRepository pruebaRepository;


    // 1- Método para obtener todos las pruebas que tuvieron incidentes
    public List<Prueba> obtenerIncidentes() {
        return pruebaRepository.findAllIncidentes();
    }

    // 2- Método para obtener los incidentes de un empleado específico
    public List<Prueba> incidentesPorEmpleado(int empleadoId) {
        return pruebaRepository.findIncidenteByEmpleadoId(empleadoId);
    }

    // 3- Método para obtener los kilómetros recorridos por un vehículo en un período específico
    public double kilometrosPorVehiculoYPeriodo(String patente, LocalDate inicio, LocalDate fin) {

        return 0.0;
    }

    // 4- Método para obtener las pruebas realizadas para un vehículo
    public List<Prueba> pruebasPorVehiculo(String patente) {
        return pruebaRepository.findByVehiculoPatente(patente);
    }



    
    @Override
    public Prueba create(Prueba entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void update(Prueba entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Prueba delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Prueba findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Prueba> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public boolean existsById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }


}
