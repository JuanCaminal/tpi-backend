package tp.backend.gateway.config;

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
public class ResourceServerConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // Endpoints accesibles solo por empleados
                        .requestMatchers(HttpMethod.POST, "/api/test-drives/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/notifications/**").hasRole("EMPLOYEE")

                        // Endpoints accesibles solo por usuarios asociados a vehículos
                        .requestMatchers(HttpMethod.POST, "/api/vehicles/**").hasRole("VEHICLE_USER")

                        // Endpoints accesibles solo por administradores
                        .requestMatchers(HttpMethod.GET, "/api/reports/**").hasRole("ADMIN")

                        // Cualquier otra petición requiere autenticación
                        .anyRequest().authenticated()
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
