package com.example.kafka.backend.repository;

import com.example.kafka.backend.service.AverageHypeFactorService;
import com.example.kafka.payload.AverageHypeFactorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AverageHypeFactorRepositoryImpl implements AverageHypeFactorRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<AverageHypeFactorModel> findAll() {
        return jdbcTemplate.query("SELECT * from hype", BeanPropertyRowMapper.newInstance(AverageHypeFactorModel.class));
    }

    @Override
    public void save(AverageHypeFactorModel averageHypeFactorModel) {
        jdbcTemplate.update("INSERT INTO hype (id, hypefactor, averagehypefactor) VALUES(?,?,?)",
               averageHypeFactorModel.getId(), averageHypeFactorModel.getHypeFactor(), averageHypeFactorModel.getAverageHypeFactor());
    }
}
