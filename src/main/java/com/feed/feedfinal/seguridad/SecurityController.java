package com.feed.feedfinal.seguridad;

import com.feed.feedfinal.seguridad.SecurityEvent;
import com.feed.feedfinal.seguridad.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    private SecurityService service;

    @PostMapping("/event")
    public SecurityEvent createEvent(@RequestBody SecurityEvent event) {
        return service.saveEvent(event);
    }

    @GetMapping("/events")
    public Iterable<SecurityEvent> getEvents() {
        return service.getAllEvents();
    }


}
