package tp.backend.agencia.services.interfaces;

import tp.backend.agencia.models.Prueba;
import tp.backend.agencia.models.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface PruebaService extends Service<Prueba, Integer> {

    public List<Prueba> getPruebasEnCurso();

    public Prueba getPruebaEnCursoVehiculo(Integer idVehiculo);

    public void finalizarPrueba(Integer idPrueba, String comentario);
}
