package com.forohub.challenge.api.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title("API Foro.Hub.API")
                        .description("""
                                        API-REST de la aplicación Foro Hub, que contiene las funcionalidades de CRUD
                                         de Registro y Login, Usuarios, Perfiles, Topicos y Respuestas.
                                        """)
                        .contact(new Contact()
                                .name("Equipo Backend")
                                .email("viadfeur@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://foro_hub/api/licenscia")))

                .addSecurityItem(new SecurityRequirement().addList("bearer-key"));
    }

    @Bean
    public String message(){
        return "Bearer is working";
    }

}
