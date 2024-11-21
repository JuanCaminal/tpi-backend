package tp.backend.agencia.models;

import java.util.List;

import lombok.Data;

@Data
public class GeoConfigurationWrapper {
    
    private Coordenadas coordenadasAgencia;
    private double radioAdmitidoKm;
    private List<AreaRestringida> zonasRestringidas;

    
}
