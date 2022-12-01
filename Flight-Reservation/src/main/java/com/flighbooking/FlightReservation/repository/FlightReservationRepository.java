package com.flighbooking.FlightReservation.repository;

import com.flighbooking.FlightReservation.model.FlightReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightReservationRepository extends JpaRepository<FlightReservationModel, Long> {
}
