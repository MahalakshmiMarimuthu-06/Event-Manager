package com.mahalakshmi.Eventmanager.service;

import com.mahalakshmi.Eventmanager.entity.Event;
import com.mahalakshmi.Eventmanager.entity.Registration;
import com.mahalakshmi.Eventmanager.repository.EventRepository;
import com.mahalakshmi.Eventmanager.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    public RegistrationRepository regRepo;

    @Autowired
    public EventRepository eventRepo;

    public Registration registerUser(Registration reg) {

        if (reg.getEvent() == null || reg.getEvent().getId() == null) {
            throw new RuntimeException("Event ID missing");
        }

        Long eventId = reg.getEvent().getId();

        Event event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        // ❗ Check seats
        if (event.getSeats() <= 0) {
            throw new RuntimeException("Event is full");
        }

        // ❗ Duplicate check
        Optional<Registration> existing =
                regRepo.findByEmailAndEventId(reg.getEmail(), eventId);

        if (existing.isPresent()) {
            throw new RuntimeException("User already registered");
        }

        // ✅ Reduce seat
        event.setSeats(event.getSeats() - 1);
        eventRepo.save(event);

        reg.setEvent(event);

        return regRepo.save(reg);
    }


}