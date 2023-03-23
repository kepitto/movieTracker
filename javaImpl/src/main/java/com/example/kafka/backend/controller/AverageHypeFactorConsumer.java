package com.example.kafka.backend.controller;

import com.example.kafka.backend.service.AverageHypeFactorService;
import com.example.kafka.payload.AverageHypeFactorModel;
import com.example.kafka.schema.AverageHypeFactor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AverageHypeFactorConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AverageHypeFactorConsumer.class);


    private final AverageHypeFactorService averageHypeFactorService;

    public AverageHypeFactorConsumer(AverageHypeFactorService averageHypeFactorService) {
        this.averageHypeFactorService = averageHypeFactorService;
    }

    @KafkaListener(topics="AVERAGE_HYPE_FACTOR_UPDATED", groupId = "movieConsumerGroup")
    public void consume(AverageHypeFactor hypeFactor){
        LOGGER.info(String.format("HypeFactor received is: %s", hypeFactor));
        AverageHypeFactorModel averageHypeFactorModel = new AverageHypeFactorModel(0L, hypeFactor.getHypeFactor(), hypeFactor.getAverageHypeFactor());
        LOGGER.info(String.format("HypeFactor transformed to Model is: %s", averageHypeFactorModel));
        try {
            averageHypeFactorService.saveAveragHypeFactorModel(averageHypeFactorModel);
        } catch(Exception e){
            LOGGER.error(e.getMessage());
        }
    }
}
