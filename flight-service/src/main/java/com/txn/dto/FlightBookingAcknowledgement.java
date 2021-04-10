package com.txn.dto;

import com.txn.entity.PassengerInfo;
import com.txn.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowledgement {
	private String status;
	private double totalFare;
	private String pnrNo;
	private PassengerInfo passengerInfo;
}
