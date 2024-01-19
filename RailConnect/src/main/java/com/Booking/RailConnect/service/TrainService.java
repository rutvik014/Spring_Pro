package com.Booking.RailConnect.service;

import com.Booking.RailConnect.entity.Train;

import java.util.List;

public interface TrainService {

    Train addTrain(Train train);

    Train updateTrain(Train train, Long trainId);

    void removeTrain(Long trainId);

    Train getTrainDetails(Long trainId);

    List<Train> getAllTrains();
}
