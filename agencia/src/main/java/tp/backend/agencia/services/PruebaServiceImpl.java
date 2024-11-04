package tp.backend.agencia.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import tp.backend.agencia.models.Prueba;
import tp.backend.agencia.models.Vehiculo;
import tp.backend.agencia.repositories.PruebaRepository;
import tp.backend.agencia.services.interfaces.PruebaService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PruebaServiceImpl extends ServiceImpl<Prueba, Integer> implements PruebaService {

    private final PruebaRepository pruebaRepository;

    @Override
    public Prueba create(Prueba prueba) {

        List<Prueba> pruebasEnCursoVehiculo = this.getPruebasEnCurso(prueba.getVehiculo());

        if (prueba.getInteresado().estaHabilitado() && pruebasEnCursoVehiculo.isEmpty()) {
            this.pruebaRepository.save(prueba);
        }
        return prueba;
    }

    @Override
    public void update(Prueba entity) {
        this.pruebaRepository.save(entity);
    }

    @Override
    public Prueba delete(Integer id) {
        Prueba entity = this.pruebaRepository.findById(id).orElse(null);
        this.pruebaRepository.delete(entity);
        return entity;
    }

    @Override
    public Prueba findById(Integer id) {
        return this.pruebaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No existe"));
    }

    @Override
    public List<Prueba> findAll() {
        return this.pruebaRepository.findAll();
    }

    @Override
    public boolean existsById(Integer id) {
        return this.pruebaRepository.existsById(id);
    }

    @Override
    public List<Prueba> getPruebasEnCurso() {
        Prueba ejemploPruebaActiva = new Prueba();

        ejemploPruebaActiva.setFechaHoraFin(null); // Buscamos pruebas sin fechaFin (pruebas activas)

        // Busca todas las pruebas que coincidan con el ejemplo
        Example<Prueba> example = Example.of(ejemploPruebaActiva);

        return pruebaRepository.findAll(example);
    }

    public List<Prueba> getPruebasEnCurso(Vehiculo vehiculo) {
        Prueba ejemploPruebaActiva = new Prueba();
        ejemploPruebaActiva.setVehiculo(vehiculo);
        ejemploPruebaActiva.setFechaHoraFin(null); // Buscamos pruebas sin fechaFin (pruebas activas)

        // Busca todas las pruebas que coincidan con el ejemplo
        Example<Prueba> example = Example.of(ejemploPruebaActiva);

        return this.pruebaRepository.findAll(example);
    }

    @Override
    public void finalizarPrueba(Integer idPrueba, String comentario) {
        Prueba prueba = findById(idPrueba);

        prueba.setComentarios(comentario);
        prueba.setFechaHoraFin(LocalDateTime.now());
        this.update(prueba);
    }
}
