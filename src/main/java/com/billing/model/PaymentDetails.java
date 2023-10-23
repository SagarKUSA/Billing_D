package com.billing.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paymentDetails")
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	private int billId;
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	private Date paidDate;
	private double amount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Date getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "PaymentDetails [id=" + id + ", billId=" + billId + ", paidDate=" + paidDate + ", amount=" + amount
				+ "]";
	}
	
	
	

}
