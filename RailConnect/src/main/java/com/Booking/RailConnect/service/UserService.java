package com.Booking.RailConnect.service;

import com.Booking.RailConnect.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User updateUser(User user);

    void deleteUser(Long userId);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User findByUsername(String username);

    User registerUser(User user);

    User getUserDetails(Long userId);
}
