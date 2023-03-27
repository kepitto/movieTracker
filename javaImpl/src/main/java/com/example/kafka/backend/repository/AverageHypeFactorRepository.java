package com.example.kafka.backend.repository;

import com.example.kafka.payload.AverageHypeFactorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AverageHypeFactorRepository extends JpaRepository<AverageHypeFactorModel, Long> {
}
