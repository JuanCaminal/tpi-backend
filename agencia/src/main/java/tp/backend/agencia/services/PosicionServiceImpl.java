package tp.backend.agencia.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.backend.agencia.models.Posicion;
import tp.backend.agencia.repositories.PosicionRepository;
import tp.backend.agencia.services.interfaces.PosicionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PosicionServiceImpl extends ServiceImpl<Posicion, Integer> implements PosicionService {

    private final PosicionRepository posicionRepository;

    @Override
    public Posicion create(Posicion entity) {
        return null;
    }

    @Override
    public void update(Posicion entity) {
        this.posicionRepository.save(entity);
    }

    @Override
    public Posicion delete(Integer id) {
        return null;
    }

    @Override
    public Posicion findById(Integer id) {
        return null;
    }

    @Override
    public List<Posicion> findAll() {
        return List.of();
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    public Posicion verificarZonaPeligrosa(Posicion posicion) {
        // consumir API catedra
        Boolean esRiesgosa = verificarZonaPeligrosaAPI(posicion.getLatitud(), posicion.getLatitud());

        if (esRiesgosa) {
            posicion.setEsRiesgosa(esRiesgosa);
            this.update(posicion);
        }
        return posicion;
    }

    private Boolean verificarZonaPeligrosaAPI(Double latitud, Double latitud1) {
        return false;
    }
}
