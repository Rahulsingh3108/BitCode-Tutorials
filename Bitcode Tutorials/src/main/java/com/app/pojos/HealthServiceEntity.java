package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "HealthServices")
public class HealthServiceEntity extends BaseEntity {
	private String serviceName;
	private String mentor;
	private double price;
	private int duration;
	private String description;
	private String imagePath;
	
	@ManyToMany(mappedBy = "userServices")
	@JsonIgnore
	private List<User> users = new ArrayList<>();
	
	@ManyToMany(mappedBy = "cartHealthServices")
	@JsonIgnore
	private List<Cart> cart = new ArrayList<>();
	
	@ManyToMany(mappedBy = "healthServiceEntitys")
	@JsonIgnore
	private List<Order> order = new ArrayList<>();
	
	@OneToMany(mappedBy = "healthServiceEntity", cascade = CascadeType.ALL,
			fetch=FetchType.LAZY, orphanRemoval = true)
	@JsonIgnore
	private List<HealthServiceDetails> healthServiceDetails = new ArrayList<>();

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getMentor() {
		return mentor;
	}

	public void setMentor(String mentor) {
		this.mentor = mentor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public HealthServiceEntity(String serviceName, String mentor, double price, int duration, String description,
			String imagePath, List<User> users, List<Cart> cart, List<Order> order,
			List<HealthServiceDetails> healthServiceDetails) {
		super();
		this.serviceName = serviceName;
		this.mentor = mentor;
		this.price = price;
		this.duration = duration;
		this.description = description;
		this.imagePath = imagePath;
		this.users = users;
		this.cart = cart;
		this.order = order;
		this.healthServiceDetails = healthServiceDetails;
	}

	public List<HealthServiceDetails> getHealthServiceDetails() {
		return healthServiceDetails;
	}

	public void setHealthServiceDetails(List<HealthServiceDetails> healthServiceDetails) {
		this.healthServiceDetails = healthServiceDetails;
	}

	public HealthServiceEntity() {
		super();
	}
	
}