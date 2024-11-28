package tp.backend.agencia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tp.backend.agencia.models.Agencia;
import tp.backend.agencia.models.Coordenadas;
import tp.backend.agencia.services.GeoLocationService;
import tp.backend.agencia.util.GeoChecker;


@RestController
public class GeoLocationController {

    @Autowired
    private GeoLocationService geoLocationService;

    @GetMapping("/api/v1/location")
    public Agencia getGeoConfiguration() {
        return geoLocationService.fetchConfiguracion();
    }

    @PostMapping("/check-restricted-area")
    public boolean isPointInsideRestrictedArea(@RequestParam double lat, @RequestParam double lon) {
        Coordenadas coordenadas = new Coordenadas();
        coordenadas.setLat(lat);
        coordenadas.setLon(lon);
        System.err.println("Received point: " + coordenadas);
        return GeoChecker.isAllowedPoint(coordenadas, geoLocationService.fetchConfiguracion());
    }

    
}
