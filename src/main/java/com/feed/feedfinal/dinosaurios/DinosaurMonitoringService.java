package com.feed.feedfinal.dinosaurios;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class DinosaurMonitoringService {

    public Flux<Integer> getDinosaurData() {
        // Genera números consecutivos del 1 al 100 con un retraso de 1 segundo
        return Flux.range(1, 100)
                .delayElements(Duration.ofMillis(100)) // Reduce el retraso para pruebas rápidas
                .log(); // Registro del flujo
    }
}
