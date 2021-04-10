package com.txn.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.txn.dto.FlightBookingAcknowledgement;
import com.txn.dto.FlightBookingRequest;
import com.txn.entity.PassengerInfo;
import com.txn.entity.PaymentInfo;
import com.txn.repository.PassengerInfoRespository;
import com.txn.repository.PaymentInfoRepository;
import com.txn.util.PaymentUtils;

@Service
public class FlightBookingService {
	
	@Autowired
	private PassengerInfoRespository passengerInfoRespository;

	@Autowired
	private PaymentInfoRepository paymentInfoRepository;
	
	
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {
		PassengerInfo passengerInfo = request.getPassengerInfo();
		passengerInfo = passengerInfoRespository.save(passengerInfo);
		
		PaymentInfo paymentInfo = request.getPaymentInfo();
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		paymentInfo.setPassengerId(passengerInfo.getId());
		paymentInfo.setAmount(passengerInfo.getFare());
		
		paymentInfo = paymentInfoRepository.save(paymentInfo);
		
		return new FlightBookingAcknowledgement("Success", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);
	}
}
