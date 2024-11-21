package tp.backend.agencia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.backend.agencia.models.GeoConfigurationWrapper;
import tp.backend.agencia.services.GeoConfigurationService;


@RestController
public class GeoConfigurationController {

    @Autowired
    private GeoConfigurationService geoConfigurationService;

    @GetMapping("/api/v1/configuration")
    public GeoConfigurationWrapper getGeoConfiguration() {
        return geoConfigurationService.fetchConfiguracion();
    }
}
