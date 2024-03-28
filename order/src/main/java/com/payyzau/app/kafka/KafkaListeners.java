package com.payyzau.app.kafka;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.payyzau.app.entity.Product;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.DataInput;

@Service
public class KafkaListeners {
    private ObjectMapper objectMapper;

    public KafkaListeners(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "newProduct", groupId = "groupId")
    void listener(String data) throws JsonProcessingException {
        Product product = objectMapper.readValue(data, Product.class);

        System.out.println(product);
    }
}
