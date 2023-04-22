package com.example.kafka.backend.controller;

import com.example.kafka.backend.service.AverageHypeFactorService;
import com.example.kafka.payload.AverageHypeFactorModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hype")
public class AverageHypeFactorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AverageHypeFactorController.class);

    private final AverageHypeFactorService averageHypeFactorService;

    public AverageHypeFactorController(AverageHypeFactorService averageHypeFactorService) {
        this.averageHypeFactorService = averageHypeFactorService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getHype")
    public List<AverageHypeFactorModel> getHype(){
        LOGGER.info("Get Hype");
        return averageHypeFactorService.getAllHype();
    }
}
