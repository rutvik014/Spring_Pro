package com.Booking.RailConnect.controller;

import com.Booking.RailConnect.entity.Train;
import com.Booking.RailConnect.exception.TrainNotFouundException;
import com.Booking.RailConnect.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping("/add")
    public ResponseEntity<Train> addTrain(@RequestBody Train train) {
        Train addedTrain = trainService.addTrain(train);
        return new ResponseEntity<>(addedTrain, HttpStatus.CREATED);
    }

    @GetMapping("/details/{trainId}")
    public ResponseEntity<Train> getTrainDetails(@PathVariable Long trainId) {
        Train train = trainService.getTrainDetails(trainId);
        return new ResponseEntity<>(train, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Train>> getAllTrains() {
        List<Train> trains = trainService.getAllTrains();
        return new ResponseEntity<>(trains, HttpStatus.OK);
    }

    @ExceptionHandler(TrainNotFouundException.class)
    public ResponseEntity<String> handleTrainNotFoundException(TrainNotFouundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
