package com.flighbooking.PriceRequest;

import com.flighbooking.PriceRequest.model.PriceRequestModel;
import com.flighbooking.PriceRequest.repository.PriceRequestRepository;
import com.flighbooking.PriceRequest.service.PriceRequestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
class PriceRequestApplicationTests {

	@Test
	void contextLoads() {
	}

}
