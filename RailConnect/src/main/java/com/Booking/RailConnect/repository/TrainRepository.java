package com.Booking.RailConnect.repository;

import com.Booking.RailConnect.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {

    // You can add custom query methods if needed
}
