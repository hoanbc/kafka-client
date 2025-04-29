package com.example.kafka.controller;

import com.example.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/publish")
    public String publishMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return "Đã gửi tin nhắn: " + message;
    }
}
