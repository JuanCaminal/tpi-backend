package tp.backend.reportes.clases;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Incidente {

    @Id
    private Long id;  // Identificador único para el incidente
    private String descripcion;  // Descripción del incidente
    private LocalDate fecha;  // Fecha del incidente
    private String placa;  // Placa del vehículo relacionado
    private int empleadoId;  // ID del empleado relacionado
    private double kilometrosRecorridos;  // Kilómetros recorridos en el incidente

    // Constructor
    public Incidente(Long id, String descripcion, LocalDate fecha, String placa, int empleadoId, double kilometrosRecorridos) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.placa = placa;
        this.empleadoId = empleadoId;
        this.kilometrosRecorridos = kilometrosRecorridos;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public double getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public void setKilometrosRecorridos(double kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }
}
