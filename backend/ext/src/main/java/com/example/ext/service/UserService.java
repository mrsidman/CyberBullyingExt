package com.example.ext.service;

import com.example.ext.entity.User;
import com.example.ext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(String username, String password, String email) {
        User user = new User(username, password, email);
        return userRepository.save(user);
    }
}
