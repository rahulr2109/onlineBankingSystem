package com.example.loansystem_backend.controller;

import com.example.loansystem_backend.model.User;
import com.example.loansystem_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

class loginUser{
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public loginUser(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    String username;
    String pwd;
}

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
    public ResponseEntity<String> login(@RequestBody loginUser user) {
        User foundUser = userService.findByUsername(user.getUsername());
        if (foundUser != null && userService.checkPassword(foundUser, user.getPwd())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

}
