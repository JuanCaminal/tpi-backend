package tp.backend.notificaciones.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.backend.notificaciones.models.NotificacionEmpleado;
import tp.backend.notificaciones.repositories.NotificacionEmpleadoRepository;
import tp.backend.notificaciones.services.interfaces.NotificacionEmpleadoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificacionEmpleadoServiceImpl extends ServiceImpl<NotificacionEmpleado, Integer> implements NotificacionEmpleadoService {

    private final NotificacionEmpleadoRepository notificacionEmpleadoRepository;

    @Override
    public NotificacionEmpleado create(NotificacionEmpleado entity) {
        this.notificacionEmpleadoRepository.save(entity);
        return entity;
    }

    @Override
    public void update(NotificacionEmpleado entity) {
        this.notificacionEmpleadoRepository.save(entity);

    }

    @Override
    public NotificacionEmpleado delete(Integer id) {
        NotificacionEmpleado entity = this.notificacionEmpleadoRepository.findById(id).orElse(null);
        this.notificacionEmpleadoRepository.delete(entity);
        return entity;
    }

    @Override
    public NotificacionEmpleado findById(Integer id) {
        return this.notificacionEmpleadoRepository.findById(id).orElse(null);
    }

    @Override
    public List<NotificacionEmpleado> findAll() {
        return this.notificacionEmpleadoRepository.findAll();
    }

    @Override
    public boolean existsById(Integer id) {
        return this.notificacionEmpleadoRepository.existsById(id);
    }
}
