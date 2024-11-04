package tp.backend.notificaciones.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import tp.backend.notificaciones.constants.MedioNotificacion;

@Entity(name = "Notificaciones_Empleados")
@Data
@NoArgsConstructor
public class NotificacionEmpleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EMPLEADO",  nullable = false)
    private Empleado empleado;

    @Column(name = "MENSAJE")
    private String mensaje;

    //puede ser por mail, telefono
    @Enumerated(EnumType.STRING)
    @Column(name = "MEDIO")
    private MedioNotificacion medio;
}
