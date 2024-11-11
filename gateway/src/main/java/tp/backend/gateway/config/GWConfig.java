package tp.backend.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class GWConfig {

    @Bean
    public RouteLocator configurarRutas(RouteLocatorBuilder builder,
                                        @Value("${tpi-backend.url-microservicio-agencia}") String uriAgencia,
                                        @Value("${tpi-backend.url-microservicio-notificaciones}") String uriNotificaciones) {
        return builder.routes()
                // Ruteo al Microservicio de Agencia
                .route(p -> p.path("/api/agencia/**").uri(uriAgencia))

                // Rutas para pruebas y vehículos, que están en el microservicio de Agencia
                .route(p -> p.path("/api/agencia/pruebas/**").uri(uriAgencia))
                .route(p -> p.path("/api/agencia/vehiculos/**").uri(uriAgencia))

                // Rutas para Notificaciones
                .route(p -> p.path("/api/notificaciones/**").uri(uriNotificaciones))

                // Rutas para reportes, suponiendo que los reportes están en el microservicio de Agencia
                .route(p -> p.path("/api/agencia/reportes/**").uri(uriAgencia))

                .build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // Rutas protegidas para pruebas (solo empleados)
                        .requestMatchers(HttpMethod.POST, "/api/agencia/pruebas/generar-prueba")
                        .hasRole("EMPLEADO")
                        .requestMatchers(HttpMethod.PATCH, "/api/agencia/pruebas/{id_prueba}/finalizar")
                        .hasRole("EMPLEADO")

                        // Rutas protegidas para Vehículos (solo usuarios asociados)
                        .requestMatchers(HttpMethod.GET, "/api/agencia/vehiculos/{id_vehiculo}/posicion")
                        .hasRole("USUARIO_VEHICULO")

                        // Rutas protegidas para Notificaciones (solo empleados)
                        .requestMatchers(HttpMethod.POST, "/api/notificaciones/empleado")
                        .hasRole("EMPLEADO")
                        .requestMatchers(HttpMethod.POST, "/api/notificaciones/promociones")
                        .hasRole("EMPLEADO")

                        // Rutas protegidas para Reportes (solo administradores)
                        .requestMatchers(HttpMethod.GET, "/api/agencia/reportes/**")
                        .hasRole("ADMINISTRADOR")
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
        return http.build();

    }


    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        var jwtAuthenticationConverter = new JwtAuthenticationConverter();
        var grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

        // Se especifica el nombre del claim a analizar
        grantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");
        // Se agrega este prefijo en la conversión por una convención de Spring
        grantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");

        // Se asocia el conversor de Authorities al Bean que convierte el token JWT a un objeto Authorization
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        // También se puede cambiar el claim que corresponde al nombre que luego se utilizará en el objeto
        // Authorization
        // jwtAuthenticationConverter.setPrincipalClaimName("user_name");

        return jwtAuthenticationConverter;
    }

}