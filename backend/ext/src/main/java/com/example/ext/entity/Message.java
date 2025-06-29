package com.example.ext.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Message {
    @Id
    private ObjectId id;
    @NonNull
    private String username;
    @NonNull
    private String content;
    @NonNull
    private LocalDateTime timestamp;
}
