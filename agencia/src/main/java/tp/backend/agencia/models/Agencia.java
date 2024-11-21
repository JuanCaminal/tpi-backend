package tp.backend.agencia.models;

import java.util.List;

import lombok.Data;

@Data
public class Agencia {

    private Coordenadas coordenadasAgencia;
    private double radioAdmitidoKm;
    private List<AreaRestringida> zonasRestringidas;


}
