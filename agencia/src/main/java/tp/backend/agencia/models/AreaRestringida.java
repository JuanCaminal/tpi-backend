package tp.backend.agencia.models;

import lombok.Data;

@Data
public class AreaRestringida {

    private Coordenadas noroeste;
    private Coordenadas sureste;

}
