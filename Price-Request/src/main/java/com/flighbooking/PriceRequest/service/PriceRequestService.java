package com.flighbooking.PriceRequest.service;

import com.flighbooking.PriceRequest.model.PriceRequestModel;
import com.flighbooking.PriceRequest.repository.PriceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PriceRequestService {

    @Autowired
    private PriceRequestRepository priceRequestRepository;

    public List<PriceRequestModel> findAllPriceRequest() {
        return priceRequestRepository.findAll();
    }

    public Optional<PriceRequestModel> findById(int priceRequestId) {
        return priceRequestRepository.findById(priceRequestId);
    }

    @Transactional
    public PriceRequestModel saveOrUpdatePriceRequest(PriceRequestModel priceRequestModel) {
        return priceRequestRepository.save(priceRequestModel);
    }

    public Optional<PriceRequestModel> findByFlightNumber(int flightNumber){
        return priceRequestRepository.findByFlightNumber(flightNumber);
    }

    @Transactional
    public void deletePriceRequest(PriceRequestModel priceRequestModel) {
        priceRequestRepository.delete(priceRequestModel);
    }

    public List<PriceRequestModel> findByCompany(String company) {
        return priceRequestRepository.findByCompany(company);
    }

    public List<String> getDistinctOrigins() {
        return priceRequestRepository.getDistinctOrigins();
    }

    public List<PriceRequestModel> findByOrigin(String origin) {
        return priceRequestRepository.findByOrigin(origin);
    }

    public List<PriceRequestModel> findByOriginAndDestination(String origin, String destination) {
        return priceRequestRepository.findByOriginAndDestination(origin, destination);
    }

    public List<PriceRequestModel> findByDepartureDate(LocalDate departureDate) {
        return priceRequestRepository.findByDepartureDate(departureDate);
    }
}
