package com.mahalakshmi.Eventmanager.controller;

import com.mahalakshmi.Eventmanager.entity.Registration;
import com.mahalakshmi.Eventmanager.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "*") // allow frontend
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @PostMapping
    public Registration register(@RequestBody Registration reg) {
        return service.registerUser(reg);
    }
}