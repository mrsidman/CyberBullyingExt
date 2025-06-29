package com.example.ext.controller;

import com.example.ext.entity.User;
import com.example.ext.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> signup(@RequestBody String username, String password, String email) {
        try {
            User user = userService.createUser(username, password, email);
            if (user != null) {
                return new  ResponseEntity<>(user, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }

}
