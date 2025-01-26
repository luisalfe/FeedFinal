package com.feed.feedfinal.seguridad;

import com.feed.feedfinal.seguridad.SecurityEvent;
import com.feed.feedfinal.seguridad.SecurityEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    @Autowired
    private SecurityEventRepository repository;

    public SecurityEvent saveEvent(SecurityEvent event) {
        return repository.save(event);
    }

    public Iterable<SecurityEvent> getAllEvents() {
        return repository.findAllOrdered();
    }
}
