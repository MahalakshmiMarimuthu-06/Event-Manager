package com.mahalakshmi.Eventmanager.service;

import com.mahalakshmi.Eventmanager.entity.Event;
import com.mahalakshmi.Eventmanager.entity.Registration;
import com.mahalakshmi.Eventmanager.repository.EventRepository;
import com.mahalakshmi.Eventmanager.repository.RegistrationRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceTest {

    @InjectMocks
    private RegistrationService service;

    @Mock
    private RegistrationRepository regRepo;

    @Mock
    private EventRepository eventRepo;

    // ✅ TEST CASE 1: SUCCESS
    @Test
    void testRegisterUser_Success() {

        Event event = new Event();
        event.setId(1L);
        event.setSeats(10);

        Registration reg = new Registration();
        reg.setUserName("Maha");
        reg.setEmail("maha@gmail.com");

        Event inputEvent = new Event();
        inputEvent.setId(1L);
        reg.setEvent(inputEvent);

        when(eventRepo.findById(1L)).thenReturn(Optional.of(event));
        when(regRepo.save(any())).thenReturn(reg);

        Registration result = service.registerUser(reg);

        assertNotNull(result);
        verify(regRepo).save(any());
    }

    // ❌ TEST CASE 2: EVENT NOT FOUND
    @Test
    void testRegisterUser_EventNotFound() {

        Registration reg = new Registration();

        Event inputEvent = new Event();
        inputEvent.setId(99L);
        reg.setEvent(inputEvent);

        when(eventRepo.findById(99L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            service.registerUser(reg);
        });

        assertEquals("Event not found", ex.getMessage());
    }
}