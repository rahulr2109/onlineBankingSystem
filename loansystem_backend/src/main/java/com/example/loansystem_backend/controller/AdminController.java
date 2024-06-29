package com.example.loansystem_backend.controller;

import com.example.loansystem_backend.model.User;
import com.example.loansystem_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController; // Inject UserController to reuse login functionality

//    @PostMapping("/admin/addLoanOfficer")
//    public ResponseEntity<String> addLoanOfficer(@RequestBody User loanOfficer, @RequestParam("username") String username) {
//        if (!isAdmin(username)) {
//            return ResponseEntity.status(403).body("Unauthorized");
//        }
//        loanOfficer.setRole("LO");
//        User registeredUser = userService.register(loanOfficer);
//        return ResponseEntity.ok("Officer added sucessfully");
//    }
//
//    private boolean isAdmin(String username) {
//        // Retrieve user from database based on username
//        User user = userService.findByUsername(username);
//        // Check if user exists and has admin role
//        return user != null && "AO".equals(user.getRole());
//    }

    // Other admin-related endpoints
}

