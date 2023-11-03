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

import com.billing.exception.ResourceNotFoundException;
import com.billing.model.Bill;
import com.billing.model.PaymentDetails;
import com.billing.service.BillService;
import com.billing.service.PaymentDetailsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BillController {
	@Autowired
	private BillService billService;

	@Autowired
	private PaymentDetailsService detailsService;

	@PostMapping("/addBill")
	@ApiOperation(value = "Request to add bill")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Invalid Request"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public Bill generateBill(@RequestBody Bill bill) {

		Bill bill1 = billService.generateBill(bill);

		if (bill1.getPaymentDetails() == null) {

			throw new ResourceNotFoundException("The given Bill details with Payment not avilable :" + bill);
		}
		List<PaymentDetails> payments = bill.getPaymentDetails();

		for (PaymentDetails payment : payments) {

			payment.setBillId(bill.getId());
			detailsService.doPayment(payment);
		}
		return bill1;

	}

	@PutMapping("/editBill")
	@ApiOperation(value = "Request to edit bill")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public Bill updataeBill(@RequestBody Bill bill) {

		Bill bill1 = billService.updataeBill(bill);

		if (bill1.getPaymentDetails() == null) {

			throw new ResourceNotFoundException("The given Bill details with Payment not avilable :" + bill);
		}
		List<PaymentDetails> payments = bill.getPaymentDetails();

		for (PaymentDetails payment : payments) {

			payment.setBillId(bill.getId());
			detailsService.updatePayment(payment);
		}
		return bill1;
	}

	@GetMapping("/getAllBills")
	@ApiOperation(value = "Request to get all bills")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public List<Bill> getAllBills() {
		List<Bill> get = billService.getAllBills();
		return get;
	}

	@GetMapping("/getById/{id}")
	@ApiOperation(value = "Request to get bill using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public Bill getBillById(@PathVariable("id") Integer id) {
		Bill get = billService.getBillById(id);
		return get;
	}

	@DeleteMapping("/deleteBill/{id}")
	@ApiOperation(value = "Request to delete bill using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public void deleteBill(@PathVariable("id") Integer id) {
		billService.deleteBill(id);
	}

	@GetMapping("/billByPage")
	@ApiOperation(value = "Request to get all bills in pages")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public List<Bill> getBillByPage(@RequestParam(defaultValue = "0") Integer pageNumber,
			@RequestParam(defaultValue = "100") Integer pageSize,
			@RequestParam(defaultValue = "status") String sortBy) {

		List<Bill> billByPage = billService.getAllBills(pageNumber, pageSize, sortBy);

		return billByPage;

	}
}
