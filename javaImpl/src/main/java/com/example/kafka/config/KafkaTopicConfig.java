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
    public NewTopic genreAvgRatingTopic(){
        return TopicBuilder.name("genreAvgRating").partitions(3).build();
    }
}
