package tp.backend.agencia.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import tp.backend.agencia.models.Agencia;
import tp.backend.agencia.models.GeoConfigurationWrapper;

@Service
public class GeoConfigurationService {

    private final WebClient webClient;

    public GeoConfigurationService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://labsys.frc.utn.edu.ar").build();
    }

    public Agencia fetchConfiguracion() {
        return webClient.get()
                .uri("/apps-disponibilizadas/backend/api/v1/configuracion/")
                .retrieve()
                .bodyToMono(Agencia.class)
                .block(); // Blocking for simplicity, consider alternatives for non-blocking calls
    }
}
