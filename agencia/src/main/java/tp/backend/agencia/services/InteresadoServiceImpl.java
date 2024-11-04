package tp.backend.agencia.services;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.backend.agencia.models.Interesado;
import tp.backend.agencia.repositories.InteresadoRepository;
import tp.backend.agencia.services.interfaces.InteresadoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InteresadoServiceImpl extends ServiceImpl<Interesado, Integer> implements InteresadoService {

    private final InteresadoRepository repository;


    @Override
    public Interesado create(Interesado entity) {
        this.repository.save(entity);
        return entity;
    }

    @Override
    public void update(Interesado entity) {
        this.repository.save(entity);
    }

    @Override
    public Interesado delete(Integer id) {
        return null;
    }

    @Override
    public Interesado findById(Integer id) {
        return null;
    }

    @Override
    public List<Interesado> findAll() {
        return List.of();
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    public void restringirInteresado(Interesado interesado) {
        interesado.setRestringido(true);
        this.update(interesado);
    }
}
