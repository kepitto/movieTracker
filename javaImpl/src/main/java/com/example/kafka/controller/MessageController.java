package com.example.kafka.controller;

import com.example.kafka.kafka.KafkaProducer;
import com.example.kafka.payload.MovieModel;
import com.example.kafka.schema.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/sendMovie")
    public ResponseEntity<String> publish(@RequestBody MovieModel model){
        Movie movie = Movie.newBuilder().build();
        movie.setMovieName(model.getMovieName());
        movie.setGenre(model.getGenre());
        movie.setRating(model.getRating());
        movie.setId(UUID.randomUUID().toString());
        kafkaProducer.sendMessage(movie);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
