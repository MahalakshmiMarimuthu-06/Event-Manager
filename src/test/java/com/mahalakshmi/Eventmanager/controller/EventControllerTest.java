package com.mahalakshmi.Eventmanager.controller;

import com.mahalakshmi.Eventmanager.entity.Event;
import com.mahalakshmi.Eventmanager.service.EventService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventControllerTest {

    @Test
    void testGetEvents() {

        EventService service = mock(EventService.class);

        EventController controller = new EventController();
        controller.service = service;

        Event event = new Event();
        event.setId(1L);
        event.setName("Tech Fest");

        when(service.getAllEvents()).thenReturn(List.of(event));

        List<Event> result = controller.getEvents();

        assertEquals(1, result.size());
        assertEquals("Tech Fest", result.get(0).getName());
    }
}