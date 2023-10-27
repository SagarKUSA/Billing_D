package com.billing.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.billing.model.Bill;
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

	@Override
public List<PaymentDetails> getAllBills(Integer pageNumber, Integer pageSize , String sortBy) {
		
		Pageable paging = PageRequest.of(pageNumber, pageSize , Sort.by("billId").ascending());
		
		Page< PaymentDetails> paymentResult = detailsRepository.findAll(paging);
		
		if(paymentResult.hasContent()) {
			return paymentResult.getContent();
	}
         return new ArrayList<PaymentDetails>();
	
	}
}
