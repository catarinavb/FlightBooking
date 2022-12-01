package com.flighbooking.PriceRequest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "price")
public class PriceRequestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer priceRequestId;
    @Column(nullable = false, length = 20)
    private String origin;
    @Column(nullable = false, length = 20)
    private String destination;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false, unique = true)
    private int flightNumber;
    @Column(nullable = false, length = 10)
    private String company;
    @Column(nullable = false)
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate departureDate;
    @Column(nullable = false)
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime departureTime;
    @Column(nullable = false)
    private int transitTime; //in minutes
    @Column(nullable = false)
    private boolean luggage;
    @Column(nullable = false)
    private LocalDateTime insertionDate;

    public PriceRequestModel() {
    }

    public PriceRequestModel(Integer priceRequestId, String origin, String destination, double price, int flightNumber, String company, LocalDate departureDate, LocalTime departureTime, int transitTime, boolean luggage, LocalDateTime insertionDate) {
        this.priceRequestId = priceRequestId;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.flightNumber = flightNumber;
        this.company = company;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.transitTime = transitTime;
        this.luggage = luggage;
        this.insertionDate = insertionDate;
    }


    public Integer getPriceRequestId() {
        return priceRequestId;
    }

    public void setPriceRequestId(Integer priceRequestId) {
        this.priceRequestId = priceRequestId;
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

    public LocalDateTime getInsertionDate() {
        return insertionDate;
    }

    public void setInsertionDate(LocalDateTime insertionDate) {
        this.insertionDate = insertionDate;
    }

    @Override
    public String toString() {
        return "PriceRequestModel{" +
                "priceRequestId=" + priceRequestId +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                ", flightNumber=" + flightNumber +
                ", company='" + company + '\'' +
                ", departureDate=" + departureDate +
                ", departureTime=" + departureTime +
                ", transitTime=" + transitTime +
                ", luggage=" + luggage +
                ", insertionDate=" + insertionDate +
                '}';
    }
}
