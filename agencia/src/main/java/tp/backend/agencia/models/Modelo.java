package tp.backend.agencia.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Modelos")
@Data
@NoArgsConstructor
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MARCA",  nullable = false)
    private Marca marca;

    @Column(name = "DESCRIPCION", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehiculo> vehiculos;
}
