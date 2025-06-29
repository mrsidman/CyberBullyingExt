package com.example.ext.controller;

import com.example.ext.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/predict")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @PostMapping
    public ResponseEntity<?> isBullied(@RequestBody String username, String content){
        boolean isBullied = predictionService.prediction(username, content);
        return new ResponseEntity<>(isBullied, HttpStatus.OK);
    }
}
