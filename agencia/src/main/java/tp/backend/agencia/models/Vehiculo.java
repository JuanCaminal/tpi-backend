package tp.backend.agencia.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MODELO",  nullable = false)
    private Modelo modelo;

    @Column(name = "ANIO", nullable = false)
    private Integer anio;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Posicion> posiciones;


    public Vehiculo(String patente, Modelo modelo) {
        this.patente = patente;
        this.modelo = modelo;
        this.anio = 2019; // Valor por defecto
    }

    public Posicion getPosicionActual() {
        return posiciones.stream().max(Comparator.comparing(Posicion::getFechaHora)).orElse(null);
    }

}
