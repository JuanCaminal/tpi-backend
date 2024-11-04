package tp.backend.agencia.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Empleados")
@Data
@NoArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false)
    private String apellido;

    @Column(name = "TELEFONO_CONTACTO")
    private String telefono;

    @Column(name = "MAIL")
    private String mail;
}
