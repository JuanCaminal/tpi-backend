package tp.backend.agencia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tp.backend.agencia.models.Agencia;
import tp.backend.agencia.models.Coordenadas;
import tp.backend.agencia.services.GeoConfigurationService;
import tp.backend.agencia.util.GeoChecker;


@RestController
public class GeoConfigurationController {

    @Autowired
    private GeoConfigurationService geoConfigurationService;

    @GetMapping("/api/v1/configuration")
    public Agencia getGeoConfiguration() {
        return geoConfigurationService.fetchConfiguracion();
    }

    @PostMapping("/check-restricted-area")
    public boolean isPointInsideRestrictedArea(@RequestParam double lat, @RequestParam double lon) {
        Coordenadas coordenadas = new Coordenadas();
        coordenadas.setLat(lat);
        coordenadas.setLon(lon);
        System.err.println("Received point: " + coordenadas);
        return GeoChecker.isAllowedPoint(coordenadas, geoConfigurationService.fetchConfiguracion());
    }

    
}
