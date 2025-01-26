package com.feed.feedfinal.dinosaurios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class DinosaurController {

    @Autowired
    private DinosaurMonitoringService dinosaurMonitoringService;

    @GetMapping("/api/dinosaur-data")
    public Flux<Integer> getDinosaurData() {
        return dinosaurMonitoringService.getDinosaurData();
    }
}
