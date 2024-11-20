package tp.backend.agencia.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.backend.agencia.models.Empleado;
import tp.backend.agencia.repositories.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Optional<Empleado> getEmpleadoById(int legajo) {
        return empleadoRepository.findById(legajo);
    }

    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public void deleteEmpleado(int legajo) {
        empleadoRepository.deleteById(legajo);
    }
}
