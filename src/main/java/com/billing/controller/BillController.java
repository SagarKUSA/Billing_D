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

import com.billing.model.Bill;
import com.billing.model.PaymentDetails;
import com.billing.service.BillService;

@RestController
public class BillController {
	@Autowired
    private BillService billService;
	

	@PostMapping("/addBill")
public Bill generateBill(@RequestBody Bill bill) {
	Bill bill1 = billService.generateBill(bill);
	return bill1;
}

	@PutMapping("/editBill")
public Bill updataeBill(@RequestBody Bill bill) {
	Bill edit= billService.updataeBill(bill);
	return edit;
}
	@GetMapping("/getAllBills")
public List<Bill> getAllBills(){
	List<Bill> get= billService.getAllBills();
	return get;
}
@GetMapping("/getById/{id}")
public Bill getBillById(@PathVariable ("id") Integer id) {
Bill get =	billService.getBillById(id);
return get;
}
@DeleteMapping("/deleteBill/{id}")
public void deleteBill(@PathVariable ("id") Integer id) {
	billService.deleteBill(id);
}


}
