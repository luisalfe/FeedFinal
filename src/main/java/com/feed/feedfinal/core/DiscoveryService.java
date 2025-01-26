package com.feed.feedfinal.core;

import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class DiscoveryService {

    private final ReactiveDiscoveryClient discoveryClient;

    public DiscoveryService(ReactiveDiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public Flux<String> getAvailableServices() {
        return discoveryClient.getServices();
    }
}

