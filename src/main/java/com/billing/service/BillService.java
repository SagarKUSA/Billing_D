package com.billing.service;

import java.util.List;

import com.billing.model.Bill;

public interface BillService {
	
public Bill generateBill(Bill bill);

public Bill updataeBill(Bill bill);
	
public List<Bill> getAllBills();

public List<Bill> getAllBills(Integer pageNumber , Integer pageSize , String sortBy);

public Bill getBillById(Integer id);

public void deleteBill(Integer id);



}
