package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**") // Aplica a todas las rutas
                .allowedOrigins("*") // Permite todos los orígenes
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite los métodos GET, POST, PUT, DELETE y OPTIONS
                .allowedHeaders("*") // Permite cualquier encabezado
                .allowCredentials(false) // Deshabilitado porque no es compatible con "*" en allowedOrigins
                .maxAge(3600); // Duración máxima de la caché CORS
    }
}
