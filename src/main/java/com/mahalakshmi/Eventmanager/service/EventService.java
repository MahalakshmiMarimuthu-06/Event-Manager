package com.mahalakshmi.Eventmanager.service;

import com.mahalakshmi.Eventmanager.entity.Event;
import com.mahalakshmi.Eventmanager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository repo;

    public List<Event> getAllEvents() {
        return repo.findAll();
    }

    public Event saveEvent(Event event) {
        return repo.save(event);
    }
}