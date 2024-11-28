package tp.backend.reportes.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Vehiculos")
@Data
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "PATENTE", nullable = false)
    private String patente;

    @Column(name = "ID_MODELO",  nullable = false)
    private int modeloId;

    @Column(name = "ANIO", nullable = false)
    private Integer anio;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prueba> pruebas;







}
