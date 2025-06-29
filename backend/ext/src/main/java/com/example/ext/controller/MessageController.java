package com.example.ext.controller;

import com.example.ext.entity.Message;
import com.example.ext.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public ResponseEntity<?> findAllAggressive(String username) {
        LocalDateTime period = LocalDateTime.now().minusDays(7);
        List<Message> messages = messageService.getAggressiveMessages(username, period);
        if (messages != null) {
            return new ResponseEntity<>(messages, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
