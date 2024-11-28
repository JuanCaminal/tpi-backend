package tp.backend.notificaciones.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.backend.notificaciones.models.NotificacionPublicidad;
import tp.backend.notificaciones.repositories.NotificacionPublicidadRepository;
import tp.backend.notificaciones.services.interfaces.NotificacionPublicidadService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificacionPublicidadServiceImpl extends ServiceImpl<NotificacionPublicidad, Integer> implements NotificacionPublicidadService {

    private final NotificacionPublicidadRepository notificacionPublicidadRepository;

    @Override
    public NotificacionPublicidad create(NotificacionPublicidad entity) {
        this.notificacionPublicidadRepository.save(entity);
        return entity;
    }

    @Override
    public void update(NotificacionPublicidad entity) {
        this.notificacionPublicidadRepository.save(entity);
    }

    @Override
    public NotificacionPublicidad delete(Integer id) {
        NotificacionPublicidad notificacionPublicidad = this.notificacionPublicidadRepository.findById(id).orElse(null);
        this.notificacionPublicidadRepository.delete(notificacionPublicidad);
        return notificacionPublicidad;
    }

    @Override
    public NotificacionPublicidad findById(Integer id) {
        return this.notificacionPublicidadRepository.findById(id).orElse(null);
    }

    @Override
    public List<NotificacionPublicidad> findAll() {
        return this.notificacionPublicidadRepository.findAll();
    }

    @Override
    public boolean existsById(Integer id) {
        return this.notificacionPublicidadRepository.existsById(id);
    }
}
