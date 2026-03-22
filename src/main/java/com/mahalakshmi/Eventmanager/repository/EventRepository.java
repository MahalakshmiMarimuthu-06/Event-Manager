package com.mahalakshmi.Eventmanager.repository;

import com.mahalakshmi.Eventmanager.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
