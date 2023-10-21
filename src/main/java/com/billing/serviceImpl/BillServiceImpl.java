package com.billing.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.model.Bill;
import com.billing.repository.BillRepository;
import com.billing.service.BillService;

@Service
public class BillServiceImpl implements BillService {
	@Autowired
	private BillRepository billRepository;

	@Override
	public Bill generateBill(Bill bill) {
		Bill addBill = billRepository.save(bill);
		return addBill;
	}

	@Override
	public Bill updataeBill(Bill bill) {
	Bill updateBill =	billRepository.save(bill);
		return updateBill;
	}
	

	@Override
	public List<Bill> getAllBills() {
	List<Bill> getAllBill =	billRepository.findAll();
		return getAllBill;
	}

	@Override
	public Bill getBillById(Integer id) {
		Optional<Bill> get = billRepository.findById(id);
		return get.get();
	}

	@Override
	public void deleteBill(Integer id) {
		billRepository.deleteById(id);
	}




}
