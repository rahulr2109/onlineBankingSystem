package com.example.loansystem_backend.service;

import com.example.loansystem_backend.model.User;
import com.example.loansystem_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public boolean checkPassword(User user, String rawPassword) {
        return Objects.equals(rawPassword, user.getPassword());
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
