package com.Booking.RailConnect.controller;

import com.Booking.RailConnect.entity.Booking;
import com.Booking.RailConnect.exception.BookingNotFoundException;
import com.Booking.RailConnect.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<Booking> bookTicket(@RequestBody Booking booking) {
        Booking bookedTicket = bookingService.bookTicket(booking);
        return new ResponseEntity<>(bookedTicket, HttpStatus.CREATED);
    }

    @GetMapping("/details/{bookingId}")
    public ResponseEntity<Booking> getBookingDetails(@PathVariable Long bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<String> handleBookingNotFoundException(BookingNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
