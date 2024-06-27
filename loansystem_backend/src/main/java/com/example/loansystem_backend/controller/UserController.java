package com.example.loansystem_backend.controller;

import com.example.loansystem_backend.model.User;
import com.example.loansystem_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        user.setRole("CU");
        User registeredUser =  userService.register(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String pwd) {
        System.out.println("Username: " + username + " Password: " + pwd);
        User foundUser = userService.findByUsername(username);
        if (foundUser != null && userService.checkPassword(foundUser, pwd)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

}
