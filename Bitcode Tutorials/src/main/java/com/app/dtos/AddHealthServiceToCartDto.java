package com.app.dtos;

public class AddHealthServiceToCartDto {
	private Long healthServiceId;
	private Long cartId;
	public Long getHealthServiceId() {
		return healthServiceId;
	}
	public void setHealthServiceId(Long healthServiceId) {
		this.healthServiceId = healthServiceId;
	}
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public AddHealthServiceToCartDto(Long healthServiceId, Long cartId) {
		super();
		this.healthServiceId = healthServiceId;
		this.cartId = cartId;
	}
	public AddHealthServiceToCartDto() {
		super();
	}
}
