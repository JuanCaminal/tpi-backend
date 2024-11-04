package tp.backend.notificaciones.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import tp.backend.notificaciones.constants.MedioNotificacion;

import java.util.List;

@Entity(name = "Notificaciones_Publicidad")
@Data
@NoArgsConstructor
public class NotificacionPublicidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "notificacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Destinatario> destinatarios;

    @Column(name = "MENSAJE")
    private String mensaje;

    //puede ser por mail, telefono
    @Enumerated(EnumType.STRING)
    @Column(name = "MEDIO")
    private MedioNotificacion medio;
}
