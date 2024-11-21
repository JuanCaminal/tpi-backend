package tp.backend.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GWConfig {

    @Bean
    public RouteLocator configurarRutas(RouteLocatorBuilder builder,
                                        @Value("${tpi-backend.url-microservicio-agencia}") String uriAgencia,
                                        @Value("${tpi-backend.url-microservicio-notificaciones}") String uriNotificaciones)  {
        return builder.routes()
                // Ruteo al Microservicio de Personas
                .route(p -> p.path("/api/agencia/**").uri(uriAgencia))
                // Ruteo al Microservicio de Entradas
                .route(p -> p.path("/api/notificaciones/**").uri(uriNotificaciones))
                .build();
    }
}