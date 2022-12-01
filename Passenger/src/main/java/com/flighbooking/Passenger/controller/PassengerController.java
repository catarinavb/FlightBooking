package com.flighbooking.Passenger.controller;

import com.flighbooking.Passenger.dto.PassengerDto;
import com.flighbooking.Passenger.model.PassengerModel;
import com.flighbooking.Passenger.service.PassengerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins= "*")
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;


    @PostMapping("/add")
    public PassengerModel savePassenger(@RequestBody PassengerModel passengerModel){
        System.out.println("Inside addPassenger in Controller");
        return passengerService.saveOrUpdatePassenger(passengerModel);
    }

    //ResponseEntity of an object to retrieve an object and send a response
    @PostMapping("/")
    public ResponseEntity<Object> savePassengerDTO(@RequestBody @Valid PassengerDto passengerDto){
        System.out.println("Inside addPassengerDTO in Controller");
        if(passengerService.findByNif(passengerDto.getNif()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: NIF is already in use!");
        }
        PassengerModel passengerModel = new PassengerModel();
        BeanUtils.copyProperties(passengerDto, passengerModel);
        passengerModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(passengerService.saveOrUpdatePassenger(passengerModel));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> findPassengerById(@PathVariable("id") int passengerId){
        Optional<PassengerModel> passengerModelOptional = passengerService.findPassengerById(passengerId);
        if(!passengerModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Passenger not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(passengerModelOptional.get());
    }

    @GetMapping("/list")
    public ResponseEntity<List<PassengerModel>> findAllPassengers() {
        return ResponseEntity.status(HttpStatus.OK).body(passengerService.findAllPassengers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePassenger(@PathVariable("id") int passengerId){
        Optional<PassengerModel> passengerModelOptional = passengerService.findPassengerById(passengerId);
        if(!passengerModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Passenger not found.");
        }
        passengerService.deletePassenger(passengerModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Passenger deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePassenger(@PathVariable("id") int passengerId, @RequestBody @Valid PassengerDto passengerDto){
        Optional<PassengerModel> passengerModelOptional = passengerService.findPassengerById(passengerId);
        if(!passengerModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Passenger not found.");
        }
        //get the passenger found by id
        PassengerModel finalPassenger = passengerModelOptional.get();
        //setting its properties accordingly with the fetch data from inserted passenger
        finalPassenger.setFirstname(passengerDto.getFirstname());
        finalPassenger.setSurname(passengerDto.getSurname());
        finalPassenger.setNationality(passengerDto.getNationality());
        finalPassenger.setNif(passengerDto.getNif());
        finalPassenger.setAge(passengerDto.getAge());
        return ResponseEntity.status(HttpStatus.OK).body(passengerService.saveOrUpdatePassenger(finalPassenger));
    }

}
