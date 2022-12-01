package com.flighbooking.PriceRequest;

import com.flighbooking.PriceRequest.model.PriceRequestModel;
import com.flighbooking.PriceRequest.repository.PriceRequestRepository;
import com.flighbooking.PriceRequest.service.PriceRequestService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest //kinda makes a bridge between JUnit resources and SpringBoot ones
public class PriceRequestServiceTest {

/*      I've learned during this bootcamp methods' tests should follow these requirements:
        Name is written containing 3 parts:
            1.name of the method,
            2.scenario we're testing,
            3.expected behavior.
            Ex: CanBeCancelledBy_UserIsAdmin_ReturnsTrue()

        Inside each test method we have 3 parts: TRIPLE A
            1.arrange (where we initialize our objects - instance of a class)
            2.act (where we act on this object - we call the method we're testing)
            3.assert (where we verify is the result is correct)*/

        //In this testing class, I've created a setup method which runs before tests to avoid duplication/boilerplate code
        //This way tests are going to use the same objects for testing purpose


    @Autowired
    private PriceRequestService service;

    @MockBean
    private PriceRequestRepository repository;

    @BeforeEach //runs before all the tests, used to initialize data from repository for example
    public void setup() {
        //1.arrange (where we initialize our objects - instance of a class)
        PriceRequestModel priceRequestModel = new PriceRequestModel(3, "Oporto", "Lisbon", 20.00, 1113, "Ryanair", LocalDate.of(2022, 8, 2), LocalTime.of(10, 37), 65, false, LocalDateTime.now());
        PriceRequestModel priceRequestModelTwo = new PriceRequestModel(4, "Oporto", "Madrid", 42.00, 1114, "Easy-Jet", LocalDate.of(2022, 12, 1), LocalTime.of(18, 12), 82, false, LocalDateTime.now());

        List<PriceRequestModel> priceRequestModelList = new ArrayList<>();
        priceRequestModelList.add(priceRequestModel);
        priceRequestModelList.add(priceRequestModelTwo);

        //2.act (where we act on this object - we call the method we're testing)
        //when an instance of PriceRequestModel is needed this will return it through @MockBean
        Mockito.when(repository.findAll()).thenReturn(priceRequestModelList);
        Mockito.when(repository.findById(priceRequestModel.getPriceRequestId())).thenReturn(java.util.Optional.of(priceRequestModel));

    }

    @Test
    public void findAllPriceRequest_listWithTwoPriceRequestModels_shouldReturnTwoObjects() {
        //3.expected behavior
        Assertions.assertEquals(2, service.findAllPriceRequest().size());
    }

    /*@Test
    public void findById_givenIdOfFour_ShouldReturnPriceRequestModelTwo() {
        int id = 4;
        PriceRequestModel priceRequestModel = new PriceRequestModel(3, "Oporto", "Lisbon", 20.00, 1113, "Ryanair", LocalDate.of(2022, 8, 2), LocalTime.of(10, 37), 65, false, LocalDateTime.now());
        PriceRequestModel priceRequestModelTwo = new PriceRequestModel(4, "Oporto", "Madrid", 42.00, 1114, "Easy-Jet", LocalDate.of(2022, 12, 1), LocalTime.of(18, 12), 82, false, LocalDateTime.now());

        List<PriceRequestModel> priceRequestModelList = new ArrayList<>();
        priceRequestModelList.add(priceRequestModel);
        priceRequestModelList.add(priceRequestModelTwo);
        Mockito.when(repository.findById(id)).thenReturn(priceRequestModelList));
        Assertions.assertEquals(1, service.findById(id).coun);
    }*/

    @Test
    public void saveOrUpdatePriceRequest_insertPriceRequest_shouldSavePriceRequest() {
        PriceRequestModel newPriceRequest = new PriceRequestModel(5, "France", "Madrid", 102.00, 1115, "Testing", LocalDate.of(2022, 12, 2), LocalTime.of(8, 45), 106, false, LocalDateTime.now());
        Mockito.when(repository.save(newPriceRequest)).thenReturn(newPriceRequest);
        Assertions.assertEquals(newPriceRequest, service.saveOrUpdatePriceRequest(newPriceRequest));
    }
}
