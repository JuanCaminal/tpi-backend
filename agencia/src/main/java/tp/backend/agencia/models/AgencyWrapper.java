package tp.backend.agencia.models;

import java.util.List;

public class AgencyWrapper {
    private Agency coordenadasAgencia;
    private double radioAdmitidoKm;
    private List<RestrictedArea> zonasRestringidas;

    // Getters and setters
    public Agency getCoordenadasAgencia() {
        return coordenadasAgencia;
    }

    public void setCoordenadasAgencia(Agency coordenadasAgencia) {
        this.coordenadasAgencia = coordenadasAgencia;
    }

    public double getRadioAdmitidoKm() {
        return radioAdmitidoKm;
    }

    public void setRadioAdmitidoKm(double radioAdmitidoKm) {
        this.radioAdmitidoKm = radioAdmitidoKm;
    }

    public List<RestrictedArea> getZonasRestringidas() {
        return zonasRestringidas;
    }

    public void setZonasRestringidas(List<RestrictedArea> zonasRestringidas) {
        this.zonasRestringidas = zonasRestringidas;
    }
}
