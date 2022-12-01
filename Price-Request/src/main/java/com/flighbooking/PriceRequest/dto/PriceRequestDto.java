package com.flighbooking.PriceRequest.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PriceRequestDto {

    @NotBlank
    private String origin;
    @NotBlank
    private String destination;
    @NotNull
    private double price;
    @NotNull
    private int flightNumber;
    @NotBlank
    private String company;
    @NotNull
    private LocalDate departureDate;
    @NotNull
    private LocalTime departureTime;
    @NotNull
    private int transitTime;
    @NotNull
    private boolean luggage;

    @Override
    public String toString() {
        return "PriceRequestDto{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                ", flightNumber=" + flightNumber +
                ", company='" + company + '\'' +
                ", departureDate=" + departureDate +
                ", departureTime=" + departureTime +
                ", transitTime=" + transitTime +
                ", luggage=" + luggage +
                '}';
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public int getTransitTime() {
        return transitTime;
    }

    public void setTransitTime(int transitTime) {
        this.transitTime = transitTime;
    }

    public boolean getLuggage() {
        return luggage;
    }

    public void setLuggage(boolean luggage) {
        this.luggage = luggage;
    }
}
