package com.example.loansystem_backend.controller;

import com.example.loansystem_backend.model.User;
import com.example.loansystem_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/init")
public class AdminInitController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/createAdmin")
    public ResponseEntity<String> createAdmin() {
        User adminUser = new User("Admin","9999999999","admin");
        adminUser.setRole("AO");
        userRepository.save(adminUser);

        return ResponseEntity.ok("Admin created successfully");
    }
}
