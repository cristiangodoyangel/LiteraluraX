package com.aluracursos.desafio.LiteraluraX.config; // Ajusta el paquete según tu estructura.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // Marca esta clase como una clase de configuración.
public class AppConfig {

    @Bean // Define un bean para RestTemplate.
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
