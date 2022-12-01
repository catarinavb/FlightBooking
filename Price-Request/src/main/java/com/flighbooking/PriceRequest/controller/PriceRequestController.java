package com.flighbooking.PriceRequest.controller;

import com.flighbooking.PriceRequest.dto.PriceRequestDto;
import com.flighbooking.PriceRequest.model.PriceRequestModel;
import com.flighbooking.PriceRequest.service.PriceRequestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins= "*")
@RequestMapping("/priceRequest")
public class PriceRequestController {

    @Autowired
    private PriceRequestService priceRequestService;

    @PostMapping("/")
    public ResponseEntity<Object> savePriceRequest(@RequestBody @Valid PriceRequestDto priceRequestDto){
        if(priceRequestService.findByFlightNumber(priceRequestDto.getFlightNumber()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This flight number already exists!");
        }
        PriceRequestModel priceRequestModel = new PriceRequestModel();
        BeanUtils.copyProperties(priceRequestDto, priceRequestModel);
        priceRequestModel.setInsertionDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(priceRequestService.saveOrUpdatePriceRequest(priceRequestModel));
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAllPriceRequest() {
        List<PriceRequestModel> priceRequestModelOptional = priceRequestService.findAllPriceRequest();
        if(priceRequestModelOptional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Flights available at the moment.");
        return ResponseEntity.status(HttpStatus.OK).body(priceRequestService.findAllPriceRequest());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findPriceRequestById(@PathVariable("id") int priceRequestId) {
        Optional<PriceRequestModel> priceRequestModelOptional = priceRequestService.findById(priceRequestId);
        if(!priceRequestModelOptional.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Price Request not found.");
        return ResponseEntity.status(HttpStatus.OK).body(priceRequestModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePriceRequest(@PathVariable("id") int priceRequestId) {
        Optional<PriceRequestModel> priceRequestModelOptional = priceRequestService.findById(priceRequestId);
        if(!priceRequestModelOptional.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Price Request not found.");
        priceRequestService.deletePriceRequest(priceRequestModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Price Request deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePriceRequest(@PathVariable("id") int priceRequestId, @RequestBody @Valid PriceRequestDto priceRequestDto) {
        Optional<PriceRequestModel> priceRequestModelOptional = priceRequestService.findById(priceRequestId);
        if(!priceRequestModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Price Request not found.");
        }
        //get the pricerequest found by id
        PriceRequestModel finalPriceRequest = priceRequestModelOptional.get();
        //setting its properties accordingly with the fetch data from inserted passenger
        finalPriceRequest.setOrigin(priceRequestDto.getOrigin());
        finalPriceRequest.setDestination(priceRequestDto.getDestination());
        finalPriceRequest.setPrice(priceRequestDto.getPrice());
        finalPriceRequest.setFlightNumber(priceRequestDto.getFlightNumber());
        finalPriceRequest.setCompany(priceRequestDto.getCompany());
        finalPriceRequest.setDepartureDate(priceRequestDto.getDepartureDate());
        finalPriceRequest.setDepartureTime(priceRequestDto.getDepartureTime());
        finalPriceRequest.setTransitTime(priceRequestDto.getTransitTime());
        finalPriceRequest.setLuggage(priceRequestDto.getLuggage());
        return ResponseEntity.status(HttpStatus.OK).body(priceRequestService.saveOrUpdatePriceRequest(finalPriceRequest));
    }

    @GetMapping("/flightNumber/{flightNumber}")
    public ResponseEntity<Object> getPriceRequestByFlightNumber(@PathVariable("flightNumber") int flightNumber){
        Optional<PriceRequestModel> priceRequestModelOptional = priceRequestService.findByFlightNumber(flightNumber);
        if(!priceRequestModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight Number not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(priceRequestModelOptional.get());
    }

    //get by company
    @GetMapping("/airline")
    public ResponseEntity<Object> findPriceRequestByAirLine(@RequestParam("company") String company){
        List<PriceRequestModel> priceRequestModelList = priceRequestService.findByCompany(company);
        if(priceRequestModelList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Air Line not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(priceRequestModelList);
    }

    //get all origins
    @GetMapping("/origins")
    public ResponseEntity<Object> getDistinctOrigins(){
        List<String> originsList = priceRequestService.getDistinctOrigins();
        if(originsList.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Origins available at the moment.");
        return ResponseEntity.status(HttpStatus.OK).body(originsList);
    }

    //get one origin
    @GetMapping("/origin")
    public ResponseEntity<Object> findByOrigin(@RequestParam("name") String origin){
        List<PriceRequestModel> originList = priceRequestService.findByOrigin(origin);
        if(originList.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The selected Origin is not available.");
        return ResponseEntity.status(HttpStatus.OK).body(originList);
    }

    //get all destinations - based on origin and based on day
    @GetMapping("/flight")
    public ResponseEntity<Object> findByOriginAndDestination(@RequestParam("origin") String origin, @RequestParam("destination") String destination){
        List<PriceRequestModel> result = priceRequestService.findByOriginAndDestination(origin, destination);
        if(result.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Flight available from "+origin+" to "+destination+".");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/flightDate")
    public ResponseEntity<Object> findByDepartureDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate){
        List<PriceRequestModel> findByDate = priceRequestService.findByDepartureDate(departureDate);
        if(findByDate.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Flights available on "+departureDate+".");
        return ResponseEntity.status(HttpStatus.OK).body(findByDate);
    }


    //TODO insert more data in data.sql
    //Method to try filter by scales
    //get firstOrigin -> get firstOrigin.destination -> if destination doesn't exists ->
    //check rest of destinations available ->
    //and check if any of those destinations have origin equals to firstOrigin.destination

}
