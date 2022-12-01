package com.flighbooking.PriceRequest.repository;

import com.flighbooking.PriceRequest.model.PriceRequestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRequestRepository extends JpaRepository<PriceRequestModel, Integer> {

    Optional<PriceRequestModel> findByFlightNumber(int flightNumber);

    List<PriceRequestModel> findByCompany(String company);

    @Query("SELECT DISTINCT origin FROM PriceRequestModel")
    List<String> getDistinctOrigins();

    List<PriceRequestModel> findByOrigin(String origin);

    List<PriceRequestModel> findByOriginAndDestination(String origin, String destination);

    List<PriceRequestModel> findByDepartureDate(LocalDate departureDate);
}

