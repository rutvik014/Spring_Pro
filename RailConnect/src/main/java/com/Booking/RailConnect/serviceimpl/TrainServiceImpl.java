package com.Booking.RailConnect.serviceimpl;

import com.Booking.RailConnect.entity.Train;
import com.Booking.RailConnect.exception.TrainNotFouundException;
import com.Booking.RailConnect.repository.TrainRepository;
import com.Booking.RailConnect.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainRepository trainRepository;

    @Override
    public Train addTrain(Train train) {
        return trainRepository.save(train);
    }

    @Override
    public Train updateTrain(Train train, Long trainId) {
        // Logic to update train details
        return trainRepository.save(train);
    }

    @Override
    public void removeTrain(Long trainId) {
        if (!trainRepository.existsById(trainId)) {
            throw new TrainNotFouundException("Train not found with id: " + trainId);
        }

        trainRepository.deleteById(trainId);
    }

    @Override
    public Train getTrainDetails(Long trainId) {
        return trainRepository.findById(trainId)
                .orElseThrow(() -> new TrainNotFouundException("Train not found with id: " + trainId));
    }

    @Override
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }
}
