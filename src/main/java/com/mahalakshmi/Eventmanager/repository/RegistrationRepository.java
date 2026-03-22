package com.mahalakshmi.Eventmanager.repository;

import com.mahalakshmi.Eventmanager.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    Optional<Registration> findByEmailAndEventId(String email, Long eventId);

}