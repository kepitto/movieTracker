package com.example.kafka.kafka;

import com.example.kafka.schema.Movie;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics="movies", groupId = "movieConsumerGroup")
    public void consume(ConsumerRecord<String, Movie> movieRecord){
        String key = movieRecord.key();
        Movie movie = movieRecord.value();
        LOGGER.info(String.format("MovieRecord received key is: %s and value is: %s", key, movie));
    }
}
