package com.Booking.RailConnect.service;

import com.Booking.RailConnect.entity.Booking;

import java.util.List;

public interface BookingService {

    Booking bookTicket(Booking booking);

    Booking getBookingById(Long bookingId);

    List<Booking> getAllBookings();
}
