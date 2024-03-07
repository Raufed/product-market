package com.payyzau.catalog.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic newProduct() {
        return TopicBuilder.name("newProduct").build();
    }

}
