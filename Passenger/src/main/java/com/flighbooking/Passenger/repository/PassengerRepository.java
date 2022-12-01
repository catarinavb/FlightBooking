package com.flighbooking.Passenger.repository;

import com.flighbooking.Passenger.model.PassengerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerModel, Integer> {

    Optional<PassengerModel> findByNif (int nif);

}
