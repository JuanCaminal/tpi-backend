package tp.backend.agencia.models;

import lombok.Data;

@Data
public class RestrictedArea {

    private Coordenadas noroeste;
    private Coordenadas sureste;

}
