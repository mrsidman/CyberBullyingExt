package com.example.ext.service;

import com.example.ext.entity.Message;
import com.example.ext.entity.User;
import com.example.ext.repository.MessageRepository;
import com.example.ext.repository.MessageRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageRepositoryImpl messageRepositoryImpl;

    @Autowired
    private UserService userService;

    public void save(String username, String content, LocalDateTime timestamp) {
        Message message = new Message(username, content, timestamp);
        messageRepository.save(message);
    }

    public int countAggressiveMessages(String username, LocalDateTime period) {
        return messageRepositoryImpl.countAggressiveMessages(username, period);
    }

    public List<Message> getAggressiveMessages(String username, LocalDateTime period) {
        User user = userService.findByUsername(username);
        List<Message> messages = null;
        if (user.isBully()) {
            messages = messageRepositoryImpl.findAggressiveMessages(username, period);
        }
        return messages;
    }
}
