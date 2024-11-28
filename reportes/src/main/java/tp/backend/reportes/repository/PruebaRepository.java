package tp.backend.reportes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.backend.reportes.clases.Prueba;

public interface PruebaRepository extends JpaRepository<Prueba, Long> {

    // Buscar pruebas por placa
    List<Prueba> findByPlacaVehiculo(String placa);
}
