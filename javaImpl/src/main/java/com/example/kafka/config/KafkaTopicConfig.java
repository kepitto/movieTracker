package com.example.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic movieTopic(){
        return TopicBuilder.name("movies").partitions(3).build();
    }

    @Bean
    public NewTopic averageHypeFactorTopic(){
        return TopicBuilder.name("AVERAGE_HYPE_FACTOR_UPDATED").partitions(3).build();
    }
}
