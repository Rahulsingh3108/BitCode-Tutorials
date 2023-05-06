package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "Orders")
public class Order extends BaseEntity {

	@CreationTimestamp
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	private double amount;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
	        name = "Order_Course", 
	        joinColumns = { @JoinColumn(name = "orderId") }, 
	        inverseJoinColumns = {@JoinColumn(name = "healthServiceId")})
	private List<HealthServiceEntity> healthServiceEntitys = new ArrayList<>();
	
	public void addCartHealthServicesToOrder(List<HealthServiceEntity> healthServiceEntity) {
		healthServiceEntitys.addAll(healthServiceEntity);
	}
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, orphanRemoval = true)
	private TransactionDetail transactionDetail;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TransactionDetail getTransactionDetail() {
		return transactionDetail;
	}

	public void setTransactionDetail(TransactionDetail transactionDetail) {
		this.transactionDetail = transactionDetail;
	}

	public Order(LocalDate date, User user, double amount, List<HealthServiceEntity> healthServiceEntitys,
			TransactionDetail transactionDetail) {
		super();
		this.date = date;
		this.user = user;
		this.amount = amount;
		this.healthServiceEntitys = healthServiceEntitys;
		this.transactionDetail = transactionDetail;
	}

	public List<HealthServiceEntity> getHealthServiceEntitys() {
		return healthServiceEntitys;
	}

	public void setHealthServiceEntitys(List<HealthServiceEntity> healthServiceEntitys) {
		this.healthServiceEntitys = healthServiceEntitys;
	}

	public Order() {
		super();
	}
}