package com.flighbooking.PriceRequest;

import com.flighbooking.PriceRequest.model.PriceRequestModel;
import com.flighbooking.PriceRequest.repository.PriceRequestRepository;
import com.flighbooking.PriceRequest.service.PriceRequestService;
import javafx.beans.binding.When;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
class PriceRequestApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private PriceRequestService service;

	@MockBean
	private PriceRequestRepository repository;

	public void findAllPriceRequestTest() {
		when(repository.findAll())
				.thenReturn(Stream.of(new PriceRequestModel(4, "Oporto", "Madrid", 42.00, 1114, "Easy-Jet", 2022-12-01, 18:37:00, 70, false),
				new PriceRequestModel(4, "Oporto", "Madrid", 42.00, 1114, "Easy-Jet", [2022,12,01], (18,37,00), 70, false)).)
	}
}
