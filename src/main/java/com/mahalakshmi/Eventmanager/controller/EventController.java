package com.mahalakshmi.Eventmanager.controller;

import com.mahalakshmi.Eventmanager.entity.Event;
import com.mahalakshmi.Eventmanager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    EventService service;

    @GetMapping
    public List<Event> getEvents() {
        return service.getAllEvents();
    }

    @PostMapping
    public Event addEvent(@RequestBody Event event) {
        return service.saveEvent(event);
    }
}