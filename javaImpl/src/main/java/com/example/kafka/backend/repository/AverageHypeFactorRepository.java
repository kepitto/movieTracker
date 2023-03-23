package com.example.kafka.backend.repository;

import com.example.kafka.payload.AverageHypeFactorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AverageHypeFactorRepository {
    List<AverageHypeFactorModel> findAll();
    void save(AverageHypeFactorModel averageHypeFactorModel);

}
