package com.Booking.RailConnect.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "train_id", nullable = false)
    private Long trainId;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "booking_time", nullable = false)
    private LocalDateTime bookingTime;

    @Column(name = "is_payment_successful", nullable = false, columnDefinition = "varchar default 'No'")
    private String isPaymentSuccessful;

    @Column(name = "payment_type", nullable = false)
    private String paymentType;

    // Constructors
    public Booking() {
        // Default constructor
    }

    public Booking(Long userId, Long trainId, String source, String destination, LocalDateTime bookingTime,
                   boolean isPaymentSuccessful, String paymentType) {
        this.userId = userId;
        this.trainId = trainId;
        this.source = source;
        this.destination = destination;
        this.bookingTime = bookingTime;
        setPaymentSuccessful(isPaymentSuccessful);
        this.paymentType = paymentType;
    }

    // Enums for Payment Status
    public enum PaymentStatus {
        YES, NO
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getIsPaymentSuccessful() {
        return isPaymentSuccessful;
    }

    public void setIsPaymentSuccessful(String isPaymentSuccessful) {
        this.isPaymentSuccessful = isPaymentSuccessful;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    // Utility methods
    public void setPaymentSuccessful(boolean isPaymentSuccessful) {
        this.isPaymentSuccessful = isPaymentSuccessful ? PaymentStatus.YES.name() : PaymentStatus.NO.name();
    }

    public boolean isPaymentSuccessful() {
        return PaymentStatus.YES.name().equalsIgnoreCase(this.isPaymentSuccessful);
    }
}
