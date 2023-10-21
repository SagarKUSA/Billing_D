package com.billing.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int Bill_Id;
	private Date DueDate;
	private Double MinimumPayment;
	private Date createdDate;
	private Double Balance;
	private Boolean Status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBill_Id() {
		return Bill_Id;
	}
	public void setBill_Id(int bill_Id) {
		Bill_Id = bill_Id;
	}
	public Date getDueDate() {
		return DueDate;
	}
	public void setDueDate(Date dueDate) {
		DueDate = dueDate;
	}
	public Double getMinimumPayment() {
		return MinimumPayment;
	}
	public void setMinimumPayment(Double minimumPayment) {
		MinimumPayment = minimumPayment;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Double getBalance() {
		return Balance;
	}
	public void setBalance(Double balance) {
		Balance = balance;
	}
	public Boolean getStatus() {
		return Status;
	}
	public void setStatus(Boolean status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", Bill_Id=" + Bill_Id + ", DueDate=" + DueDate + ", MinimumPayment=" + MinimumPayment
				+ ", createdDate=" + createdDate + ", Balance=" + Balance + ", Status=" + Status + "]";
	}
	
	


}
