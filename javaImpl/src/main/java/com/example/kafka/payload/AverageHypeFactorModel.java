package com.example.kafka.payload;


import org.springframework.data.annotation.Id;

import java.util.List;

public class AverageHypeFactorModel {

    @Id
    private Long id;

    private List<Float> hypeFactor;

    private double averageHypeFactor;

    public AverageHypeFactorModel(Long id, List<Float> hypeFactor, double averageHypeFactor) {
        this.id = id;
        this.hypeFactor = hypeFactor;
        this.averageHypeFactor = averageHypeFactor;
    }

    public AverageHypeFactorModel(List<Float> hypeFactor, double averageHypeFactor) {
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
