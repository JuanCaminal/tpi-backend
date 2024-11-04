package tp.backend.agencia.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.jackson.JacksonDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Decoder;

@Configuration
@RequiredArgsConstructor
public class FeignClientConfig {

    private final ObjectMapper objectMapper;

    @Bean
    Decoder feignDecoder() {
        return new JacksonDecoder(objectMapper);
    }
}
