package tp.backend.agencia.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tp.backend.agencia.models.AgencyWrapper;

@Service
public class ConfigurationService {

    private final WebClient webClient;

    public ConfigurationService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://labsys.frc.utn.edu.ar").build();
    }

    public AgencyWrapper fetchConfiguracion() {
        return webClient.get()
                .uri("/apps-disponibilizadas/backend/api/v1/configuracion/")
                .retrieve()
                .bodyToMono(AgencyWrapper.class)
                .block(); // Blocking for simplicity, consider alternatives for non-blocking calls
    }
}
