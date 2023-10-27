package com.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.billing.model.Bill;
import com.billing.model.PaymentDetails;
import com.billing.service.PaymentDetailsService;

@RestController
public class PaymentDetailsController {
    
	@Autowired
	private PaymentDetailsService detailsService;
	
	@PostMapping("/doPayment")
	 public PaymentDetails doPayment (@RequestBody PaymentDetails details) {
		PaymentDetails payment = detailsService.doPayment(details);
		return payment;
	 }
	
	@GetMapping("/getPayment/{id}")
	public PaymentDetails getPayment (@PathVariable ("id") Integer id) {
		PaymentDetails details = detailsService.getPayment(id);
		return details;
	}
	 
	@GetMapping("/getAllPayments")
	 public List<PaymentDetails> getAllPayments(){
		List<PaymentDetails> getAll= detailsService.getAllPayments();
		return getAll;
	 }
	 @PutMapping("/updatePayment")
	 public PaymentDetails updatePayment (@RequestBody PaymentDetails details) {
		PaymentDetails update= detailsService.updatePayment(details);
		return update;
	 }
	 @DeleteMapping("/deltePayment/{id}")
	 public void deletePayment(@PathVariable ("id") Integer id) {
		 detailsService.deletePayment(id);
	 }
	 @GetMapping("/paymentByByPage")
	 public List<PaymentDetails> getBillByPage(@RequestParam (defaultValue = "0" )Integer pageNumber, 
	 		                        @RequestParam (defaultValue = "100") Integer pageSize,
	 		                        @RequestParam (defaultValue = "billId")String sortBy){
	 	
	 	List<PaymentDetails> paymentByByPage = detailsService.getAllBills(pageNumber, pageSize , sortBy);
	 	
	 	return paymentByByPage;
}
}
