package com.feed.feedfinal.core;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("pedidos", r -> r.path("/api/pedidos/**")
                        .uri("http://localhost:8081")) // URL fija del módulo "Pedidos"
                .route("seguridad", r -> r.path("/api/seguridad/**")
                        .uri("http://localhost:8082")) // URL fija del módulo "Seguridad"
                .route("stark", r -> r.path("/api/stark/**")
                        .uri("http://localhost:8083")) // URL fija del módulo "Stark"
                .route("dinosaurios", r -> r.path("/api/dinosaurios/**")
                        .uri("http://localhost:8084")) // URL fija del módulo "Dinosaurios"
                .route("hechizos", r -> r.path("/api/spells/**")
                        .uri("http://localhost:8085")) // URL fija del módulo "Hechizos"
                .route("marte", r -> r.path("/api/marte/**")
                        .uri("http://localhost:8086")) // URL fija del módulo "Marte"
                .build();
    }
}

