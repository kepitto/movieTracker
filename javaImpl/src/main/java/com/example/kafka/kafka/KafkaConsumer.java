package com.example.kafka.kafka;

import com.example.kafka.schema.AverageHypeFactor;
import com.example.kafka.schema.Movie;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private float totalHypeFactor = 0;
    private final List<Float> totalHypeFactorList = new ArrayList<>();

    @Autowired
    private KafkaTemplate<String, AverageHypeFactor> kafkaTemplate;

    @KafkaListener(topics="movies", groupId = "movieConsumerGroup")
    public void consume(ConsumerRecord<String, Movie> movieRecord){
        String key = movieRecord.key();
        Movie movie = movieRecord.value();
        LOGGER.info(String.format("MovieRecord received key is: %s and value is: %s", key, movie));

        // calculate hype factor for the current movie
        float hypeFactor = 0.5f * movie.getViews() + 0.3f * movie.getRating();

        // update total hype factor and number of movies received
        totalHypeFactor += hypeFactor;
        totalHypeFactorList.add(hypeFactor);

        // calculate average hype factor
        double avgHypeFactor = totalHypeFactor / totalHypeFactorList.size();

        // create an instance of AverageHypeFactor class and populate it with values
        AverageHypeFactor avgHypeFactorObj = new AverageHypeFactor();
        avgHypeFactorObj.setHypeFactor(totalHypeFactorList);
        avgHypeFactorObj.setAverageHypeFactor(avgHypeFactor);

        // send the object to Kafka topic "AVERAGE_HYPE_FACTOR_UPDATED"
        LOGGER.info(String.format("Average hype factor sent %s", avgHypeFactorObj));
        kafkaTemplate.send("AVERAGE_HYPE_FACTOR_UPDATED", avgHypeFactorObj);
    }

//    @KafkaListener(topics="AVERAGE_HYPE_FACTOR_UPDATED", groupId = "movieConsumerGroup")
//    public void consume(AverageHypeFactor hypeFactor){
//        LOGGER.info(String.format("HypeFactor received is: %s", hypeFactor));
//    }
}
