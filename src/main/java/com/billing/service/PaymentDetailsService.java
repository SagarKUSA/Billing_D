package com.billing.service;

import java.util.List;

import com.billing.model.PaymentDetails;

public interface PaymentDetailsService {
	
 public PaymentDetails doPayment (PaymentDetails details);
	 
	 public PaymentDetails getPayment (Integer id);
	 
	 public List<PaymentDetails> getAllPayments();
	 
	 public PaymentDetails updatePayment (PaymentDetails details);
	 
	 public void deletePayment(Integer id);
}
