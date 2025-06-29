package com.example.ext.repository;

import com.example.ext.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MessageRepositoryImpl implements MessageRepositoryCustom{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int countAggressiveMessages(String username, LocalDateTime period) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        query.addCriteria(Criteria.where("timestamp").gte(period));
        return (int) mongoTemplate.count(query, Message.class);
    }

    @Override
    public List<Message> findAggressiveMessages(String username, LocalDateTime period) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        query.addCriteria(Criteria.where("timestamp").gte(period));
        return mongoTemplate.find(query, Message.class);
    }
}
