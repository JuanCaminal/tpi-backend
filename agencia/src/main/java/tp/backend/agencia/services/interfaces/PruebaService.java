package tp.backend.agencia.services.interfaces;

import tp.backend.agencia.models.Prueba;
import java.util.List;

public interface PruebaService extends Service<Prueba, Integer> {

    public List<Prueba> getPruebasEnCurso();

    public Prueba getPruebaEnCursoVehiculo(Integer idVehiculo);

    public void finalizarPrueba(Integer idPrueba, String comentario);
}
