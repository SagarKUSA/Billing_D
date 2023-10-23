package com.billing.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int billId;
	private Date dueDate;
	private Double minimumPayment;
	private Date createdDate;
	private Double balance;
	private Boolean status;
	
	
	@OneToMany(mappedBy = "billId")
	private List<PaymentDetails> paymentDetails;
	
     public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBill_Id() {
		return billId;
	}
	public void setBill_Id(int billId) {
		this.billId = billId;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Double getMinimumPayment() {
		return minimumPayment;
	}
	public void setMinimumPayment(Double minimumPayment) {
		this.minimumPayment = minimumPayment;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public List<PaymentDetails> getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(List<PaymentDetails> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", bill_Id=" + billId + ", dueDate=" + dueDate + ", minimumPayment=" + minimumPayment
				+ ", createdDate=" + createdDate + ", balance=" + balance + ", status=" + status + "]";
	}
	
	
	


}
