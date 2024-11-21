package tp.backend.agencia.models;

public class RestrictedArea {
    private double northwestLatitude;
    private double northwestLongitude;
    private double southeastLatitude;
    private double southeastLongitude;

    public RestrictedArea(double northwestLatitude, double northwestLongitude, 
                          double southeastLatitude, double southeastLongitude) {
        this.northwestLatitude = northwestLatitude;
        this.northwestLongitude = northwestLongitude;
        this.southeastLatitude = southeastLatitude;
        this.southeastLongitude = southeastLongitude;
    }

    public double getNorthwestLatitude() {
        return northwestLatitude;
    }

    public void setNorthwestLatitude(double northwestLatitude) {
        this.northwestLatitude = northwestLatitude;
    }

    public double getNorthwestLongitude() {
        return northwestLongitude;
    }

    public void setNorthwestLongitude(double northwestLongitude) {
        this.northwestLongitude = northwestLongitude;
    }

    public double getSoutheastLatitude() {
        return southeastLatitude;
    }

    public void setSoutheastLatitude(double southeastLatitude) {
        this.southeastLatitude = southeastLatitude;
    }

    public double getSoutheastLongitude() {
        return southeastLongitude;
    }

    public void setSoutheastLongitude(double southeastLongitude) {
        this.southeastLongitude = southeastLongitude;
    }
}
