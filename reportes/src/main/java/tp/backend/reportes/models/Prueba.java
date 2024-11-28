package tp.backend.reportes.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Pruebas")
@Data
@NoArgsConstructor
public class Prueba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VEHICULO",  nullable = false)
    private Vehiculo vehiculo;

    @Column(name = "ID_INTERESADO", nullable = false)
    private int interesadoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EMPLEADO",  nullable = false)
    private Empleado empleado;

    @Column(name = "FECHA_HORA_INICIO", nullable = false)
    private LocalDateTime fechaHoraInicio;

    @Column(name = "FECHA_HORA_FIN", nullable = false)
    private LocalDateTime fechaHoraFin;

    @Column(name = "TUVO_INCIDENTES", nullable = false)
    private Boolean tuvoIncidentes;

    @Column(name = "COMENTARIOS")
    private String comentarios;

}
