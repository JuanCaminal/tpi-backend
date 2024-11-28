package tp.backend.agencia.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.backend.agencia.models.Posicion;
import tp.backend.agencia.models.Vehiculo;
import tp.backend.agencia.repositories.VehiculoRepository;
import tp.backend.agencia.services.interfaces.VehiculoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl extends ServiceImpl<Vehiculo, Integer> implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;


    @Override
    public Vehiculo create(Vehiculo entity) {
        return null;
    }

    @Override
    public void update(Vehiculo entity) {

    }

    @Override
    public Vehiculo delete(Integer id) {
        return null;
    }

    @Override
    public Vehiculo findById(Integer id) {
        return this.vehiculoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vehiculo> findAll() {
        return List.of();
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    public Posicion getPosicionActual(Integer idVehiculo) {
        Vehiculo vehiculo = this.findById(idVehiculo);
        return vehiculo.getPosicionActual();
    }

    @Override
    public Posicion getPosicionActualAndAnlizarRiesgo(Integer idVehiculo) {
        Posicion posicion = this.getPosicionActual(idVehiculo);


        return this.esPosicionRiesgosa(posicion);
    }

    private Posicion esPosicionRiesgosa(Posicion posicion) {
        //consumir API

        posicion.setEsRiesgosa(Boolean.FALSE);

        return posicion;
    }
}
