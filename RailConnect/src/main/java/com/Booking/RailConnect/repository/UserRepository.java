package com.Booking.RailConnect.repository;

import com.Booking.RailConnect.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    // You can add custom query methods if needed
}
