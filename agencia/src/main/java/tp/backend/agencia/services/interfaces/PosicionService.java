package tp.backend.agencia.services.interfaces;

import tp.backend.agencia.models.Posicion;

public interface PosicionService extends Service<Posicion, Integer>{
    Posicion verificarZonaPeligrosa(Posicion posicion);
}
