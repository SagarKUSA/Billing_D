package com.billing.service;

import java.util.List;

import com.billing.model.Bill;

public interface BillService {
	
public Bill generateBill(Bill bill);

public Bill updataeBill(Bill bill);
	
public List<Bill> getAllBills();

public Bill getBillById(Integer id);

public void deleteBill(Integer id);



}
