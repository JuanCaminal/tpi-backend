package tp.backend.agencia.services.interfaces;

import tp.backend.agencia.models.Posicion;
import tp.backend.agencia.models.Vehiculo;

public interface VehiculoService extends Service<Vehiculo, Integer>{
    Posicion getPosicionActual(Integer idVehiculo);
}
