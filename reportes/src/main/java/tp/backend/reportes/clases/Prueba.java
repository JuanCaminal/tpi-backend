package tp.backend.reportes.clases;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Prueba {

    @Id
    private Long id;  // Identificador único para la prueba
    private String descripcion;  // Descripción de la prueba
    private String placa;  // Placa del vehículo asociado

    // Constructor
    public Prueba(Long id, String descripcion, String placa) {
        this.id = id;
        this.descripcion = descripcion;
        this.placa = placa;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
