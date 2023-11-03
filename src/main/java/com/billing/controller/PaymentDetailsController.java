package com.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.billing.model.PaymentDetails;
import com.billing.service.PaymentDetailsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PaymentDetailsController {

	@Autowired
	private PaymentDetailsService detailsService;

	@PostMapping("/doPayment")
	@ApiOperation(value = "Request to add payment")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Invalid Request"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public PaymentDetails doPayment(@RequestBody PaymentDetails details) {
		PaymentDetails payment = detailsService.doPayment(details);
		return payment;
	}

	@GetMapping("/getPayment/{id}")
	@ApiOperation(value = "Request to get payment by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public PaymentDetails getPayment(@PathVariable("id") Integer id) {
		PaymentDetails details = detailsService.getPayment(id);
		return details;
	}

	@GetMapping("/getAllPayments")
	@ApiOperation(value = "Request to get all payment")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public List<PaymentDetails> getAllPayments() {
		List<PaymentDetails> getAll = detailsService.getAllPayments();
		return getAll;
	}

	@PutMapping("/updatePayment")
	@ApiOperation(value = "Request to update payment")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public PaymentDetails updatePayment(@RequestBody PaymentDetails details) {
		PaymentDetails update = detailsService.updatePayment(details);
		return update;
	}

	@DeleteMapping("/deletePayment/{id}")
	@ApiOperation(value = "Request to delete payment by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public void deletePayment(@PathVariable("id") Integer id) {
		detailsService.deletePayment(id);
	}
}
