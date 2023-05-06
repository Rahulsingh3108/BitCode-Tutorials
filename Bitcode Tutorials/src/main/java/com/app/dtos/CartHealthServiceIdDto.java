package com.app.dtos;

public class CartHealthServiceIdDto {
	private Long cartId;
	private Long healthServiceId;
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public Long getHealthServiceId() {
		return healthServiceId;
	}
	public void setHealthServiceId(Long healthServiceId) {
		this.healthServiceId = healthServiceId;
	}
	public CartHealthServiceIdDto(Long cartId, Long healthServiceId) {
		super();
		this.cartId = cartId;
		this.healthServiceId = healthServiceId;
	}
}
