package com.example.ext.repository;

import com.example.ext.entity.Message;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageRepositoryCustom {
    int countAggressiveMessages(String username, LocalDateTime period);
    List<Message> findAggressiveMessages(String username, LocalDateTime period);
}
