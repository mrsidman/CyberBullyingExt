package com.example.ext.service;

import com.example.ext.entity.Message;
import com.example.ext.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class PredictionService {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private EmailService emailService;

    public boolean prediction(String username, String content) {
        try {
            User user = userService.findByUsername(username);
            boolean isAggressive = true;
            boolean isBullied = false;
            if (isAggressive) {
                messageService.save(username, content, LocalDateTime.now());
                LocalDateTime period = LocalDateTime.now().minusDays(7);
                int count = messageService.countAggressiveMessages(username, period);
                isBullied = count > 0;
                if (isBullied) {
                    emailService.sendEmail(user.getEmail());
                }
                user.setBully(isBullied);
            }
            return isBullied;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }
}
