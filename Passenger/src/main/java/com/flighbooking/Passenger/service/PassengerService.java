package com.flighbooking.Passenger.service;

import com.flighbooking.Passenger.model.PassengerModel;
import com.flighbooking.Passenger.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Transactional //enable the whole transaction or rollback if something fails
    public PassengerModel saveOrUpdatePassenger(PassengerModel passenger) {
        System.out.println("Inside saveOrUpdatePassenger in Service");
        return passengerRepository.save(passenger);
    }

    public Optional<PassengerModel> findPassengerById(int passengerId) {
        return passengerRepository.findById(passengerId);
    }

    public List<PassengerModel> findAllPassengers() {
        return passengerRepository.findAll();
    }

    @Transactional
    public void deletePassenger(PassengerModel passenger) {
        passengerRepository.delete(passenger);
    }

    public Optional<PassengerModel> findByNif(int nif) {
        return passengerRepository.findByNif(nif);
    }
    /*public boolean exitsByNif(int nif) {
        return passengerRepository.exitsByNif(nif);
    }*/

    /*public PassengerModel findPassengerByName(String name) {
        return passengerRepository.findPassengerByName(name);
    }*/
}
