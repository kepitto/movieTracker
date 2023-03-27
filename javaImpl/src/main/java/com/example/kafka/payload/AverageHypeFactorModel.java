package com.example.kafka.payload;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class AverageHypeFactorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<Float> hypeFactor;

    private double averageHypeFactor;

    public AverageHypeFactorModel() {
    }

    public AverageHypeFactorModel(Long id, List<Float> hypeFactor, double averageHypeFactor) {
        this.id = id;
        this.hypeFactor = hypeFactor;
        this.averageHypeFactor = averageHypeFactor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Float> getHypeFactor() {
        return hypeFactor;
    }

    public void setHypeFactor(List<Float> hypeFactor) {
        this.hypeFactor = hypeFactor;
    }

    public double getAverageHypeFactor() {
        return averageHypeFactor;
    }

    public void setAverageHypeFactor(double averageHypeFactor) {
        this.averageHypeFactor = averageHypeFactor;
    }

    @Override
    public String toString() {
        return "AverageHypeFactorModel{" +
                "id=" + id +
                ", hypeFactor=" + hypeFactor +
                ", averageHypeFactor=" + averageHypeFactor +
                '}';
    }
}
