package com.txn.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.txn.dto.FlightBookingAcknowledgement;
import com.txn.dto.FlightBookingRequest;
import com.txn.service.FlightBookingService;

@RestController
public class BookingController {

	@Autowired
	private FlightBookingService service;
	
	@PostMapping("bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {
		return service.bookFlightTicket(request);
	}
}
