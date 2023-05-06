package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name="carts")
public class Cart extends BaseEntity {

	private double cartTotal;
	private int noItems;
	
	@OneToOne
	@JoinColumn(name = "userId", nullable = true)
	private User user;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
	        name = "Cart_Course", 
	        joinColumns = { @JoinColumn(name = "cartId") }, 
	        inverseJoinColumns = {@JoinColumn(name = "serviceId")})
	private List<HealthServiceEntity> cartHealthServices = new ArrayList<>();
	
	public void removeHealthServiceFromCart(HealthServiceEntity service) {
		this.cartHealthServices.remove(service);
	}
	
	public boolean addHealthServiceToCart(HealthServiceEntity service) {
		if(!cartHealthServices.contains(service)) { 
			this.cartHealthServices.add(service);
			return true;
		}
		return false;
	}
	
	public void emptyCartCourses() {
		this.cartTotal = 0;
		this.noItems = 0;
		cartHealthServices.clear();
	}

	public double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}

	public int getNoItems() {
		return noItems;
	}

	public void setNoItems(int noItems) {
		this.noItems = noItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<HealthServiceEntity> getCartHealthServices() {
		return cartHealthServices;
	}

	public void setCartHealthServices(List<HealthServiceEntity> cartHealthServices) {
		this.cartHealthServices = cartHealthServices;
	}

	public Cart(double cartTotal, int noItems, User user, List<HealthServiceEntity> cartHealthServices) {
		super();
		this.cartTotal = cartTotal;
		this.noItems = noItems;
		this.user = user;
		this.cartHealthServices = cartHealthServices;
	}

	public Cart() {
		super();
	}

}