package tp.backend.agencia.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Interesados")
@Data
@NoArgsConstructor
public class Interesado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TIPO_DOCUMENTO", nullable = false)
    private String tipoDocumento;

    @Column(name = "DOCUMENTO", nullable = false)
    private String documento;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false)
    private String apellido;

    @Column(name = "RESTRINGIDO", nullable = false)
    private Boolean restringido;

    @Column(name = "NRO_LICENCIA", nullable = false)
    private Long nroLicencia;

    @Column(name = "FECHA_VENCIMIENTO_LICENCIA", nullable = false)
    private LocalDateTime fechaVencimientoLicencia;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "MAIL")
    private Integer mail;

    @OneToMany(mappedBy = "interesado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prueba> pruebas;

    public Boolean tieneLicenciaVencida() {
        return fechaVencimientoLicencia.isBefore(LocalDateTime.now());
    }

    public Boolean estaHabilitado() {
        return !restringido && tieneLicenciaVencida();
    }
}
