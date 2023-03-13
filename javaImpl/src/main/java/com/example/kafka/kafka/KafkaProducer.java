package com.example.kafka.kafka;

import com.example.kafka.schema.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, Movie> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Movie> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Movie movie){
        LOGGER.info(String.format("Message sent %s", movie));
        kafkaTemplate.send("movies", movie.getId(), movie);
    }
}
