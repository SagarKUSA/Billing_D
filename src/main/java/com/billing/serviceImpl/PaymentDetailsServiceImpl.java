package com.billing.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.model.PaymentDetails;
import com.billing.repository.PaymentDetailsRepository;
import com.billing.service.PaymentDetailsService;

@Service
public class PaymentDetailsServiceImpl implements PaymentDetailsService{
	@Autowired
	private PaymentDetailsRepository detailsRepository;

	@Override
	public PaymentDetails doPayment(PaymentDetails details) {
		PaymentDetails payment= detailsRepository.save(details);
		return payment;
	}

	@Override
	public PaymentDetails getPayment(Integer id) {
	Optional<PaymentDetails> get=	detailsRepository.findById(id);
		return get.get();
	}

	@Override
	public List<PaymentDetails> getAllPayments() {
		
	    List<PaymentDetails> all = detailsRepository.findAll();
		return all;
	}

	@Override
	public PaymentDetails updatePayment(PaymentDetails details) {
		PaymentDetails update= detailsRepository.save(details);
		return update;
	}

	@Override
	public void deletePayment(Integer id) {
		detailsRepository.deleteById(id);
		
	}
	

}
