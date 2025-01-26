package com.feed.feedfinal.stark;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ExecutorServiceConfig {

    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(5); // Esto sirve para ajustar el número de hilos según la carga esperada, como no tengo ni idea por ahora lo dejo en 5
    }
}

