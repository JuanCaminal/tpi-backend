package tp.backend.agencia.services.interfaces;

import tp.backend.agencia.models.Interesado;

public interface InteresadoService extends Service<Interesado, Integer> {
    void restringirInteresado(Interesado interesado);
}
