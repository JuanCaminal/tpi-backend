package tp.backend.agencia.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Posiciones")
@Data
@NoArgsConstructor
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VEHICULO",  nullable = false)
    private Vehiculo vehiculo;

    @Column(name = "FECHA_HORA", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "LATITUD", nullable = false)
    private Double latitud;

    @Column(name = "LONGITUD", nullable = false)
    private Double longitud;
}
