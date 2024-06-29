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
<<<<<<< HEAD
    public ResponseEntity<String> login(@RequestBody loginUser user) {
        User foundUser = userService.findByUsername(user.getUsername());
        if (foundUser != null && userService.checkPassword(foundUser, user.getPwd())) {
=======
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String pwd) {
        System.out.println("Username: " + username + " Password: " + pwd);
        User foundUser = userService.findByUsername(username);
        if (foundUser != null && userService.checkPassword(foundUser, pwd)) {
>>>>>>> 5355fa76e088b0053bb6291cfdceaa11adbc925e
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

}
