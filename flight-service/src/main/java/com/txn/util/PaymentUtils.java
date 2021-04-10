package com.txn.util;

import java.util.HashMap;
import java.util.Map;

import com.txn.exception.InsufficientAmountException;


public class PaymentUtils {

	private static Map<String, Double> paymentMap = new HashMap<>();
	
	{
		paymentMap.put("acc1", 10000.0);
		paymentMap.put("acc2", 15000.0);
		paymentMap.put("acc3", 20000.0);
		paymentMap.put("acc4", 25000.0);
	}
	
	public static boolean validateCreditLimit(String accNo, double paidAmount) {
		if(paidAmount > paymentMap.get(accNo)) {
			throw new InsufficientAmountException("Insufficient Funds");
		} else {
			return true;
		}
	}
}
