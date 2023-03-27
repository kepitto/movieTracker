package com.example.kafka.backend.service;

import com.example.kafka.backend.controller.AverageHypeFactorConsumer;
import com.example.kafka.backend.repository.AverageHypeFactorRepository;
import com.example.kafka.payload.AverageHypeFactorModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class AverageHypeFactorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AverageHypeFactorConsumer.class);

    private final AverageHypeFactorRepository averageHypeFactorRepository;

    public AverageHypeFactorService(AverageHypeFactorRepository averageHypeFactorRepository) {
        this.averageHypeFactorRepository = averageHypeFactorRepository;
    }


    public void saveAveragHypeFactorModel(AverageHypeFactorModel model) {
        LOGGER.info("Database - Save the model: {}", model);
        averageHypeFactorRepository.save(model);
    }

    public List<AverageHypeFactorModel> getAllHype() {
        return averageHypeFactorRepository.findAll();
    }
}
